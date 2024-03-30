package com.sheldon.HotTopic;

import java.util.PriorityQueue;

/**
 * 26. 合并K个升序链表
 * 给你一个链表数组，每个链表都已经按升序排列。请你将所有链表合并到一个升序链表中，返回合并后的链表。
 * 链接：https://leetcode-cn.com/problems/merge-k-sorted-lists/
 */

class mergeKLists_35 {
    public ListNode mergeKLists(ListNode[] lists) {

        if (lists == null || lists.length == 0) {
            return null;
        }

        // 优先队列， 自动排序
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (ListNode node : lists) {
            if (node != null) {
                pq.add(node);
            }
        }

        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;

        while (!pq.isEmpty()) {
            ListNode minNode = pq.poll();
            current.next = minNode;
            current = current.next;
            if (minNode.next != null) {
                pq.add(minNode.next);
            }
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode[] lists = new ListNode[3];
        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(4);
        node1.next.next = new ListNode(5);
        lists[0] = node1;

        ListNode node2 = new ListNode(1);
        node2.next = new ListNode(3);
        node2.next.next = new ListNode(4);
        lists[1] = node2;

        ListNode node3 = new ListNode(2);
        node3.next = new ListNode(6);
        lists[2] = node3;

        mergeKLists_35 mergeKLists35 = new mergeKLists_35();
        ListNode result = mergeKLists35.mergeKLists(lists);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

}