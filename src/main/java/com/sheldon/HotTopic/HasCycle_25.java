package com.sheldon.HotTopic;

/**
 * 141. 环形链表
 * 给定一个链表，判断链表中是否有环。
 * https://leetcode-cn.com/problems/linked-list-cycle/
 */

public class HasCycle_25 {
    public boolean hasCycle(ListNode head) {
        // 使用快慢指针
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            // 慢指针走一步
            slow = slow.next;
            // 快指针走两步
            fast = fast.next.next;
            // 如果相遇，说明有环
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}