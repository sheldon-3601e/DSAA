package com.sheldon.HotTopic;

/**
 * 142. 环形链表 II
 * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 * https://leetcode-cn.com/problems/linked-list-cycle-ii/
 */

public class detectCycle_26 {
    public ListNode detectCycle(ListNode head) {
        // 1. 先找到快慢指针相遇的节点
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            // 慢指针走一步
            slow = slow.next;
            // 快指针走两步
            fast = fast.next.next;
            // 如果相遇，说明有环
            if (slow == fast) {
                // 2. 定义两个指针，一个指向头节点，一个指向相遇节点
                // 两个节点同时移动，相遇的节点就是环的入口
                ListNode ptr = head;
                while (ptr != slow) {
                    ptr = ptr.next;
                    slow = slow.next;
                }
                return ptr;
            }
        }
        return null;
    }
}