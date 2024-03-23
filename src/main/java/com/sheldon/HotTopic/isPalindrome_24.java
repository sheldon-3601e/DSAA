package com.sheldon.HotTopic;

/**
 * 234. 回文链表
 * 请判断一个链表是否为回文链表。
 * https://leetcode-cn.com/problems/palindrome-linked-list/
 */
class isPalindrome_24 {
    public boolean isPalindrome(ListNode head) {
        ListNode low = head;
        ListNode fast = head;
        // 通过快慢指针找到中点
        while (fast != null && fast.next != null) {
            low = low.next;
            fast = fast.next.next;
        }

        // 反转后面的链表
        ListNode prev = null;
        while (low != null) {
            ListNode next = low.next;
            low.next = prev;
            prev = low;
            low = next;
        }

        // 比较前后两个链表
        while (prev != null) {
            if (head.val != prev.val) {
                return false;
            }
            head = head.next;
            prev = prev.next;
        }

        // 将后面反转的链表再次反转
        while (prev != null) {
            ListNode next = prev.next;
            prev.next = low;
            low = prev;
            prev = next;
        }
        return true;
    }

        public static void main (String[]args){
            // 测试用例
            ListNode head = new ListNode(1);
            ListNode node1 = new ListNode(2);
            ListNode node2 = new ListNode(2);
            ListNode node3 = new ListNode(1);
            head.next = node1;
            node1.next = node2;
            node2.next = node3;
            boolean palindrome = new isPalindrome_24().isPalindrome(head);
        }
    }