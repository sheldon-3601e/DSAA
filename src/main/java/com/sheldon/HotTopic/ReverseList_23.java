package com.sheldon.HotTopic;

/**
 * 206. 反转链表
 * 反转一个单链表。
 * https://leetcode-cn.com/problems/reverse-linked-list/
 */
class ReverseList_23 {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
}