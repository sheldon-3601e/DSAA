package com.sheldon.HotTopic;

/**
 * 21. 合并两个有序链表
 * 将两个有序链表合并为一个新的有序链表并返回。
 * https://leetcode-cn.com/problems/merge-two-sorted-lists/
 */

class MergeTwoLists_27 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // 定义哨兵节点
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                cur.next = list1;
                list1 = list1.next;
            } else {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }
        // 若有一个链表为空，直接将另一个链表接到后面
        cur.next = list1 != null ? list1 : list2;
        return dummy.next;
    }

    public static void main(String[] args) {
        // 测试用例
        ListNode head1 = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(4);
        head1.next = node1;
        node1.next = node2;

        ListNode head2 = new ListNode(1);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        head2.next = node3;
        node3.next = node4;

        ListNode result = new MergeTwoLists_27().mergeTwoLists(head1, head2);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}