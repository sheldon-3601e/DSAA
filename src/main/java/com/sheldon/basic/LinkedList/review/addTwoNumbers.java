package com.sheldon.basic.LinkedList.review;

import com.sheldon.basic.LinkedList.ListNode;

/**
 * @ClassName Code01
 * @Author 26483
 * @Date 2024/2/1 9:44
 * @Version 1.0
 * @Description TODO
 */
public class addTwoNumbers {

    /**
     * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
     * <p>
     * 请你将两个数相加，并以相同形式返回一个表示和的链表。
     * <p>
     * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers01(ListNode l1, ListNode l2) {
        ListNode newList = new ListNode(-1);
        ListNode cur = newList;
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        int carry = 0; // 进位

        while (cur1 != null || cur2 != null || carry != 0) {
            int sum = (cur1 != null ? cur1.val : 0) + (cur2 != null ? cur2.val : 0) + carry;
            carry = sum / 10; // 计算进位
            cur.next = new ListNode(sum % 10); // 创建新节点，存储个位数
            cur = cur.next;

            // 更新指针
            cur1 = cur1 != null ? cur1.next : null;
            cur2 = cur2 != null ? cur2.next : null;
        }

        return newList.next;
    }

    public static void main(String[] args) {
        ListNode list1 = new ListNode(2);
        ListNode list2 = new ListNode(4);
        ListNode list3 = new ListNode(3);
        list1.next = list2;
        list2.next = list3;
        ListNode list4 = new ListNode(5);
        ListNode list5 = new ListNode(6);
        ListNode list6 = new ListNode(4);
        list4.next = list5;
        list5.next = list6;
        addTwoNumbers addTwoNumbers = new addTwoNumbers();
        ListNode listNode = addTwoNumbers.addTwoNumbers01(list1, list4);
        // 遍历链表
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
