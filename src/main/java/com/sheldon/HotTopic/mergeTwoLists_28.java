package com.sheldon.HotTopic;

/**
 * 21. 合并两个有序链表
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * 链接：https://leetcode-cn.com/problems/merge-two-sorted-lists/
 */
class mergeTwoLists_28 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode newNode = new ListNode(-1);
        ListNode cur = newNode;
        while (list1 != null || list2 != null) {
            if (list1 == null) {
                cur.next = list2;
                break;
            } else if (list2 == null) {
                cur.next = list1;
                break;
            }
            if (list1.val <= list2.val) {
                cur.next = new ListNode(list1.val);
                list1 = list1.next;
            } else {
                cur.next = new ListNode(list2.val);
                list2 = list2.next;
            }
            cur = cur.next;
        }
        return newNode.next;
    }

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        mergeTwoLists_28 mergeTwoLists28 = new mergeTwoLists_28();
        ListNode result = mergeTwoLists28.mergeTwoLists(list1, list2);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}