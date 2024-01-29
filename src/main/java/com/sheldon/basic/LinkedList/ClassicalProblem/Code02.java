package com.sheldon.basic.LinkedList.ClassicalProblem;

import com.sheldon.basic.LinkedList.ListNode;
import com.sheldon.basic.LinkedList.Utils;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @ClassName Code02
 * @Author 26483
 * @Date 2024/1/29 11:22
 * @Version 1.0
 * @Description TODO
 */
public class Code02 {
    /**
     * 给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
     */

    public static ListNode removeElements02(ListNode head, int val) {
        // 边界条件判断
        if (head == null) {
            return null;
        }

        // 定义哑节点作为头节点的前置节点，方便处理头节点删除的情况
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode prev = dummy; // 前置节点
        ListNode cur = head; // 当前节点

        // 遍历链表
        while (cur != null) {
            // 如果当前节点的值等于val，则删除当前节点
            if (cur.val == val) {
                // 前置节点的next指针指向当前节点的next指针
                prev.next = cur.next;
            } else {
                prev = cur; // 更新前置节点为当前节点
            }
            cur = cur.next; // 更新当前节点为下一个节点
        }

        return dummy.next; // 返回头节点的下一个节点
    }


    public static ListNode removeElements01(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        ArrayList<ListNode> list = new ArrayList<>();
        ListNode cur = head;
        // 遍历链表，将不等于val的节点添加到list中
        while (cur != null) {
            if (cur.val != val) {
                list.add(cur);
            }
            cur = cur.next;
        }

        // 如果list为空，说明链表中所有节点都等于val，直接返回null
        if (list.isEmpty()) {
            return null;
        }

        // 重新构造链表
        for (int i = 0; i < list.size() - 1; i++) {
            list.get(i).next = list.get(i + 1);
        }
        // 将最后一个节点的next置为null
        list.get(list.size() - 1).next = null;

        // 返回新链表的头节点
        return list.get(0);
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode cur = head;
        for (int i = 2; i < 6; i++) {
            cur.next = new ListNode(i);
            cur = cur.next;
        }
        ListNode listNode = removeElements02(head, 2);
        Utils.printLinkedList(listNode);
    }
}
