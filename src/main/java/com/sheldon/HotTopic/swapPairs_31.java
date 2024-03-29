package com.sheldon.HotTopic;

/**
 * 24. 两两交换链表中的节点
 * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
 *  https://leetcode-cn.com/problems/swap-nodes-in-pairs
 */

class swapPairs_31 {
    public ListNode swapPairs(ListNode head) {
        ListNode newNode = new ListNode(-1);
        newNode.next = head;
        // 定义前一个节点
        ListNode pre = newNode;

        while (head != null && head.next != null) {

            ListNode left = head;
            ListNode right = head.next;

            // 交换
            pre.next = right;
            left.next = right.next;
            right.next = left;

            head = left.next;
            pre = left;
        }
        return newNode.next;

    }

    public static void main(String[] args) {
        swapPairs_31 swapPairs31 = new swapPairs_31();
        ListNode head = new ListNode(1);
        ListNode node = head;
        for (int i = 2; i < 6; i++) {
            node.next = new ListNode(i);
            node = node.next;
        }
        ListNode result = swapPairs31.swapPairs(head);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

}