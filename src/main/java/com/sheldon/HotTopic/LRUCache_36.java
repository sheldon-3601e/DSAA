package com.sheldon.HotTopic;

import java.util.HashMap;
import java.util.Map;

/**
 * 146. LRU 缓存
 * 请你设计并实现一个满足  LRU (最近最少使用) 缓存 约束的数据结构。
 * 实现 LRUCache 类：
 * LRUCache(int capacity) 以 正整数 作为容量 capacity 初始化 LRU 缓存
 * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 * void put(int key, int value) 如果关键字 key 已经存在，则变更其数据值 value ；如果不存在，则向缓存中插入该组 key-value 。如果插入操作导致关键字数量超过 capacity ，则应该 逐出 最久未使用的关键字。
 * 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。
 * 链接： https://leetcode.cn/problems/lru-cache/description/?envType=study-plan-v2&envId=top-100-like
 */

class LRUCache_36 {

    // 维护一个双向链表，尾节点表示最近访问的节点。头节点表示最久未访问的节点
    class ListNode {
        int key;
        int value;
        ListNode prev;
        ListNode next;

        public ListNode() {
        }

        public ListNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private int capacity;
    // 维护一个哈希表，表示 k-v 映射关系
    private Map<Integer, ListNode> map;
    private ListNode head;
    private ListNode tail;

    public LRUCache_36(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new ListNode(-1, -1);
        tail = new ListNode(-1, -1);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        // 取出 v
        ListNode node = map.get(key);
        // 将其移动到尾节点，表示最近使用
        moveToTail(node);
        return node.value;
    }

    public void put(int key, int value) {
        // 判读该值是否已经存在
        if (map.containsKey(key)) {
            // 存在则修改 v，并将其移动到尾部
            ListNode node = map.get(key);
            node.value = value;
            moveToTail(node);
            return;
        }
        // 说明要采用淘汰策略，移动最久没有使用的数值
        if (map.size() == capacity) {
            removeHead();
        }
        // 添加新值
        ListNode newNode = new ListNode(key, value);
        map.put(key, newNode);
        addToTail(newNode);
    }

    /**
     * 移动节点到尾部
     * @param node
     */
    private void moveToTail(ListNode node) {
        // 从链表中删除节点
        node.prev.next = node.next;
        node.next.prev = node.prev;
        // 将节点移动到尾部
        tail.prev.next = node;
        node.prev = tail.prev;
        node.next = tail;
        tail.prev = node;
    }

    /**
     * 添加新值到尾部
     * @param node
     */
    private void addToTail(ListNode node) {
        // 将节点添加到尾部
        tail.prev.next = node;
        node.prev = tail.prev;
        node.next = tail;
        tail.prev = node;
    }

    /**
     * 淘汰策略 - 移动最久没有使用的值
     */
    private void removeHead() {
        // 移除链表头部节点
        ListNode headNode = head.next;
        map.remove(headNode.key);
        head.next = headNode.next;
        headNode.next.prev = head;
    }

    public static void main(String[] args) {
        LRUCache_36 lruCache36 = new LRUCache_36(2);
        lruCache36.put(1, 1);
        lruCache36.put(2, 2);
        System.out.println(lruCache36.get(1));
        lruCache36.put(3, 3);
        System.out.println(lruCache36.get(2));
        lruCache36.put(4, 4);
        System.out.println(lruCache36.get(1));
        System.out.println(lruCache36.get(3));
        System.out.println(lruCache36.get(4));

    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

