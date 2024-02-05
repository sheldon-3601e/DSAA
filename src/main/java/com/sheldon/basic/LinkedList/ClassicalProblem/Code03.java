package com.sheldon.basic.LinkedList.ClassicalProblem;

import com.sheldon.basic.LinkedList.ListNode;
import com.sheldon.basic.LinkedList.Utils;

/**
 * @ClassName Code03
 * @Author 26483
 * @Date 2024/1/30 10:25
 * @Version 1.0
 * @Description TODO
 */
public class Code03 {

    /**
     * 给定单链表的头节点 head ，将所有索引为奇数的节点和索引为偶数的节点分别组合在一起，然后返回重新排序的列表。
     * <p>
     * 第一个节点的索引被认为是 奇数 ， 第二个节点的索引为 偶数 ，以此类推。
     * <p>
     * 请注意，偶数组和奇数组内部的相对顺序应该与输入时保持一致。
     * <p>
     * 你必须在O(1)的额外空间复杂度和 O(n) 的时间复杂度下解决这个问题。
     *
     * @param head
     * @return
     */
    public static ListNode test(ListNode head) {
        // 边界条件
        if (head == null || head.next == null) {
            return head;
        }
        // 快慢指针
        ListNode slow = head;
        ListNode fast = head.next;
        //
        while (fast != null && fast.next !=null) {
            // 获取要插入的节点
            ListNode target = fast.next;
            // 移动fast指针
            fast.next = fast.next.next;
            fast = fast.next;
            // 将奇数节点插入到前方
            target.next = slow.next;
            slow.next = target;
            slow = slow.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode cur = head;
        for (int i = 2; i < 6; i++) {
            cur.next = new ListNode(i);
            cur = cur.next;
        }
        ListNode listNode = test(head);
        Utils.printLinkedList(listNode);
    }
}
