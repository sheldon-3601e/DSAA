package com.sheldon.basic.LinkedList;

import java.util.ArrayList;

/**
 * @ClassName Code04
 * @Author 26483
 * @Date 2024/1/29 9:44
 * @Version 1.0
 *  
 */
public class Code04 {

    /**
     * 给你一个链表，删除链表的倒数第n个结点，并且返回链表的头结点。
     * <p>
     * 示例 1：
     * <p>
     * 输入：head = [1,2,3,4,5], n = 2
     * 输出：[1,2,3,5]
     * 示例 2：
     * <p>
     * 输入：head = [1], n = 1
     * 输出：[]
     * 示例 3：
     * <p>
     * 输入：head = [1,2], n = 1
     * 输出：[1]
     *
     * @param head
     * @param n
     * @return
     * <a href="https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/">source</a>
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        // 因为是链表问题，还是考虑八使用快慢指针
        // 先定义快慢指针
        ListNode fast = head;
        ListNode slow = head;
        // 让快指针先走n步
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        // 如果快指针为空，则说明删除的是头指针
        if (fast == null){
            // 返回头指针的下一个节点
            return head.next;
        }
        // 如果不为空，则让快慢指针一起走，直到快指针走到最后一个节点
        // 此时，快慢指针正好相距n个节点
        // 但是我们这里的条件是 fast.next != null，所以slow指针的下一个节点就是要删除的节点
        // 即 slow 指针现在是倒数 n+1 个节点
        while (fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        // 删除倒数第n个节点
        slow.next = slow.next.next;
        return head;
    }

    public static ListNode test(ListNode head, int n) {
        ArrayList<ListNode> listNodes = new ArrayList<>();
        ListNode cur = head;
        while (cur != null) {
            listNodes.add(cur);
            cur = cur.next;
        }
        if (n + 1 > listNodes.size()) {
            return null;
        }
        ListNode del = listNodes.get(listNodes.size() - n);
        ListNode pre = listNodes.get(listNodes.size() - n - 1);
        pre.next = del.next;
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode cur = head;
        for (int i = 2; i < 6; i++) {
            cur.next = new ListNode(i);
            cur = cur.next;
        }
        Utils.printLinkedList(head);
        ListNode listNode = removeNthFromEnd(head, 2);
        Utils.printLinkedList(head);
    }

}
