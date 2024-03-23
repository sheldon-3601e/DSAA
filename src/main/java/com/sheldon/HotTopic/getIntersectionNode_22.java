package com.sheldon.HotTopic;

/**
 * 160. 相交链表
 * 编写一个程序，找到两个单链表相交的起始节点。
 * https://leetcode-cn.com/problems/intersection-of-two-linked-lists/
 */
public class getIntersectionNode_22 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = 0;
        ListNode cur = headA;
        // 计算 链表A 的长度
        while (cur != null) {
            lenA++;
            cur = cur.next;
        }
        // 计算 链表B 的长度
        cur = headB;
        int lenB = 0;
        while (cur != null) {
            lenB++;
            cur = cur.next;
        }

        // 比较两者的长度，让两个链表尾部对齐
        if (lenA > lenB) {
            for (int i = 0; i < lenA - lenB; i++) {
                headA = headA.next;
            }
        } else {
            for (int i = 0; i < lenB - lenA; i++) {
                headB = headB.next;
            }
        }

        // 同时移动两个链表，直到找到相交的节点
        while (headA != null && headB != null) {
            if (headA == headB) {
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }

    public static void main(String[] args) {

    }
}