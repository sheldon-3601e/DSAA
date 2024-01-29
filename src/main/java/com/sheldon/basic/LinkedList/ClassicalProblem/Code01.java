package com.sheldon.basic.LinkedList.ClassicalProblem;

import com.sheldon.basic.LinkedList.ListNode;
import com.sheldon.basic.LinkedList.Utils;

/**
 * @ClassName Code01
 * @Author 26483
 * @Date 2024/1/29 10:55
 * @Version 1.0
 * @TODO  递归
 */
public class Code01 {
    /**
     * 递归的模板
     * <p>
     * public ListNode reverseList(参数0) {
     *     if (终止条件)
     *         return;
     * <p>
     *     逻辑处理（可能有，也可能没有，具体问题具体分析）
     * <p>
     *     //递归调用
     *     ListNode reverse = reverseList(参数1);
     * <p>
     *     逻辑处理（可能有，也可能没有，具体问题具体分析）
     * }
     */

    /**
     *  * <p>
     *  * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
     *  * <p>
     *  * 示例 1：
     *  * <p>
     *  * 输入：head = [1,2,3,4,5]
     *  * 输出：[5,4,3,2,1]
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        return reverseListInt(head, null);
    }

    private ListNode reverseListInt(ListNode head, ListNode newHead) {
        if (head == null)
            return newHead;
        ListNode next = head.next;
        head.next = newHead;
        ListNode node = reverseListInt(next, head);
        return node;
    }

    public ListNode reverseList02(ListNode head) {
        //终止条件
        if (head == null || head.next == null)
            return head;
        //保存当前节点的下一个结点
        ListNode next = head.next;
        //从当前节点的下一个结点开始递归调用
        ListNode reverse = reverseList02(next);
        //reverse是反转之后的链表，因为函数reverseList
        // 表示的是对链表的反转，所以反转完之后next肯定
        // 是链表reverse的尾结点，然后我们再把当前节点
        //head挂到next节点的后面就完成了链表的反转。
        next.next = head;
        //这里head相当于变成了尾结点，尾结点都是为空的，
        //否则会构成环
        head.next = null;
        return reverse;
    }

    public static ListNode reverseList01(ListNode head) {
        ListNode result;
        // 如果链表为空或者只有一个节点，直接返回head
        if (head == null || head.next == null) {
            result = head;
        } else {
            ListNode prev = null;
            ListNode cur = head;// 遍历链表，反转每一个节点
            while (cur != null) {
                // 保存当前节点的下一个节点
                ListNode nextNode = cur.next;
                // 将当前节点的next指针指向前一个节点
                cur.next = prev;
                // 更新prev为当前节点
                prev = cur;
                // 更新当前节点为原链表中的下一个节点
                cur = nextNode;
            }// 最终prev指向反转后链表的头节点
            result = prev;
        }

        return result;
    }

    // 会修改原始链表的顺序，存在潜在问题
    public static ListNode test01(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = head;
        while (cur.next != null) {
            ListNode temp = cur.next;
            cur.next = temp.next;
            temp.next = head;
            head = temp;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode cur = head;
        for (int i = 2; i < 10; i++) {
            cur.next = new ListNode(i);
            cur = cur.next;
        }
        ListNode result = test01(head);
        Utils.printLinkedList(result);
    }

}
