package com.sheldon.HotTopic;

/**
 * 19. 删除链表的倒数第 N 个结点
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * https://leetcode.cn/problems/remove-nth-node-from-end-of-list/description/?envType=study-plan-v2&envId=top-100-liked
 */

class removeNthFromEnd_30 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode newNode = new ListNode(-1);
        newNode.next = head;
        // 快慢指针，找到删除节点的前一个
        ListNode low = newNode;
        ListNode fast = newNode;

        // 移动快指针
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        while (fast != null && fast.next != null) {
            fast = fast.next;
            low = low.next;
        }

        low.next = low.next.next;

        return newNode.next;

    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        new removeNthFromEnd_30().removeNthFromEnd(head, 1);
    }
}