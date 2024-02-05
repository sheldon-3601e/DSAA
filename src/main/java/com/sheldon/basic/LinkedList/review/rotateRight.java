package com.sheldon.basic.LinkedList.review;

import java.util.ArrayList;

/**
 * @ClassName rotateRight
 * @Author 26483
 * @Date 2024/2/3 2:16
 * @Version 1.0
 * @Description TODO
 */
public class rotateRight {

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    /**
     * 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
     * @param head 头节点
     * @param k 移动的位置
     * @return 移动后的头节点
     * 思路：
     * 1. 先判断边界条件，如果k=0或者head=null，直接返回head
     * 2. 先遍历一遍链表，获得链表长度
     * 3. 如果移动位数和链表长度相等，直接返回head
     * 4. 如果移动位数大于链表长度，取余数
     * 5. 找到新的头节点，新的尾节点，旧的尾节点
     * 6. 新的尾节点指向旧的头节点，旧的尾节点指向旧的头节点
     * 7. 返回新的头节点
     */
    public ListNode rotateRight01(ListNode head, int k) {
        // 边界条件
        if (k == 0 || head == null) {
            return head;
        }
        ArrayList<ListNode> list = new ArrayList<>();
        ListNode cur = head;
        while (cur != null) {
            list.add(cur);
            cur = cur.next;
        }
        cur = head;
        int size = list.size();
        int num = k % size;
        if (num == 0) {
            return head;
        }
        ListNode pre = list.get(size - 1 - num);
        ListNode newHead = pre.next;
        pre.next = null;
        ListNode last = list.get(size - 1);
        last.next = cur;
        return newHead;
    }

    public static void main(String[] args) {
        rotateRight rotateRight = new rotateRight();
        ListNode node1 = rotateRight.new ListNode(0);
        ListNode node2 = rotateRight.new ListNode(1);
        ListNode node3 = rotateRight.new ListNode(2);
        node1.next = node2;
        node2.next = node3;
        node3.next = null;
        ListNode listNode = rotateRight.rotateRight01(node1, 4);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
