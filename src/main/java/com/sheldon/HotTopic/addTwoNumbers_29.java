package com.sheldon.HotTopic;

/**
 * 2. 两数相加
 * 给你两个非空的链表，表示两个非负的整数。它们每位数字都是按照逆序的方式存储的，
 * 并且每个节点只能存储一位数字。请你将两个数相加，并以相同形式返回一个表示和的链表。
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * 链接：https://leetcode-cn.com/problems/add-two-numbers/
 */

class addTwoNumbers_29 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 哨兵节点
        ListNode newNode = new ListNode(-1);
        ListNode cur = newNode;
        // 记录前一个数的进位
        int temp = 0;
        while (l1 != null || l2 != null) {
            // 将会为空的置于 0
            // 保证遍历到每一个节点
            int val1 = l1 == null ? 0 : l1.val;
            int val2 = l2 == null ? 0 : l2.val;
            int sum = val1 + val2 + temp;
            temp = sum / 10;

            cur.next = new ListNode(sum % 10);

            // 更新节点
            cur = cur.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }

        // 处理最后一位进位
        if (temp > 0) {
            cur.next = new ListNode(temp);
        }
        return newNode.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        addTwoNumbers_29 addTwoNumbers29 = new addTwoNumbers_29();
        ListNode result = addTwoNumbers29.addTwoNumbers(l1, l2);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}