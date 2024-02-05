package com.sheldon.basic.LinkedList.review;

import com.sheldon.basic.LinkedList.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class mergeTwoLists {
    /**
     * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
     * @param list1
     * @param list2
     * @return
     */
    public ListNode mergeTwoLists01(ListNode list1, ListNode list2) {
        // 边界条件
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        // 创建一个虚拟节点，用来存放新的链表
        ListNode newList = new ListNode(-1);
        // 指针
        ListNode cur = newList;
        ListNode cur1 = list1;
        ListNode cur2 = list2;
        // 遍历两个链表，将较小的值放入新的链表中
        while ( cur1 != null && cur2 != null) {
            if ( cur1.val < cur2.val ) {
                cur.next = cur1;
                cur1 = cur1.next;
            } else {
                cur.next = cur2;
                cur2 = cur2.next;
            } 
            cur = cur.next;            
        }
        // 遍历结束，链表长度较长的链表还有剩余，将剩余的链表放入新的链表中
        // 三元运算符简化代码
        cur.next=cur1==null?cur2:cur1;
        // 代码作用同下
        /*
        if (cur1 == null) {
            cur.next = cur2;
        }
        if (cur2 == null) {
            cur.next = cur1;
        }*/
        return newList.next;
    }
}