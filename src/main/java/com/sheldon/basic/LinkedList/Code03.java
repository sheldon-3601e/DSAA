package com.sheldon.basic.LinkedList;

/**
 * @ClassName Code03
 * @Author 26483
 * @Date 2024/1/27 10:35
 * @Version 1.0
 * @Description TODO
 */
public class Code03 {

    /**
     * <a href="https://leetcode.cn/leetbook/read/linked-list/jjbj2/">source</a>
     * <p>
     * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null 。
     *
     * 图示两个链表在节点 c1 开始相交：
     *
     * 题目数据 保证 整个链式结构中不存在环。
     *
     * 注意，函数返回结果后，链表必须 保持其原始结构 。
     * @param headA
     * @param headB
     * @return
     *
     * 解题思路：
     * <p>
     * 1.如果两个链表长度相等，我们可以定义两个指针，分别移动到两个链表的头节点
     * 然后同时移动两个指针，并进行比较，如果相等，则返回相交节点，否则返回null
     * <p>
     * 2.如果两个链表的长度不相等，虽然两个人有交点，但是两个人会错开
     * 我们可以定义两个指针，分别移动到两个链表的头节点，然后同时移动两个指针
     * 当一个指针移动到链表的尾节点时，将其指向另一个链表的头节点，继续移动
     * 此时，相当于遍历了一个新链表（两个链表拼接起来的）
     * 这时，就回归到了第一种情况
     * 当两个指针相等时，返回相交节点，否则返回null
     */

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // 边界条件判断
        if (headA == null || headB == null) {
            return null;
        }
        // 定义两个指针
        ListNode pA = headA;
        ListNode pB = headB;
        // 当两个指针不相等时，进行循环
        while (pA != pB) {
            // 如果指针A不为空，则指针A指向下一个节点，否则指针A指向headB
            pA = (pA != null ? pA.next : headB);
            // 如果指针B不为空，则指针B指向下一个节点，否则指针B指向headA
            pB = (pB != null ? pB.next : headA);
        }
        return pA;
    }

    public static void main(String[] args) {
        // 测试没有交点的情况
        // 创建链表A：1 -> 2 -> 3 -> 4
        ListNode headA = new ListNode(1);
        headA.next = new ListNode(2);
        headA.next.next = new ListNode(3);
        headA.next.next.next = new ListNode(4);

        // 创建链表B：5 -> 6 -> 7 -> 8 -> 9
        ListNode headB = new ListNode(5);
        headB.next = new ListNode(6);
        headB.next.next = new ListNode(7);
        headB.next.next.next = new ListNode(8);
        headB.next.next.next.next = new ListNode(9);

        // 调用getIntersectionNode方法，期望返回结果为null
        ListNode intersectionNode = getIntersectionNode(headA, headB);
        if (intersectionNode == null) {
            System.out.println("两个链表没有相交，返回结果为null，测试通过！");
        } else {
            System.out.println("测试未通过！");
        }

    }

}
