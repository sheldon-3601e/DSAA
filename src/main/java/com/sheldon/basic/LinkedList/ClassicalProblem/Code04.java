package com.sheldon.basic.LinkedList.ClassicalProblem;

import com.sheldon.basic.LinkedList.ListNode;

/**
 * @ClassName Code04
 * @Author 26483
 * @Date 2024/1/30 10:59
 * @Version 1.0
 * @Description TODO
 */
public class Code04 {

    /**
     * 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
     * <p>
     *
     * 示例 1：
     * <p>
     * 输入：head = [1,2,2,1]
     * 输出：true
     * @param head
     * @return
     * @link https://leetcode-cn.com/problems/palindrome-linked-list/
     * @idea 快慢指针找到中点，反转后半部分链表，然后比较
     * <p>
     *     小结
     * <p>
     * 1.你可以同时使用多个指针。
     * <p>
     * 有时，当你为链表问题设计算法时，可能需要同时跟踪多个结点。您应该记住需要跟踪哪些结点，并且可以自由地使用几个不同的结点指针来同时跟踪这些结点。
     * <p>
     * 如果你使用多个指针，最好为它们指定适当的名称，以防将来必须调试或检查代码。
     * <p>
     * 2.在许多情况下，你需要跟踪当前结点的前一个结点。
     * 你无法追溯单链表中的前一个结点。因此，您不仅要存储当前结点，还要存储前一个结点。这在双链表中是不同的
     *
     */
    public static boolean isPalindrome(ListNode head) {
        boolean result = true;
        // 边界条件
        if (head != null && head.next != null) {
            ListNode fast = head;
            ListNode slow = head;// 通过快慢指针找到中点
            while (fast != null && fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            }// 如果fast不为空，说明链表的长度是奇数个
            if (fast != null) {
                slow = slow.next;
            }// 反转后半部分链表
            slow = reverseList(slow);// fast指针重新指向头部
            fast = head;// 循环比较
            while (slow != null) {
                if (fast.val != slow.val) {
                    result = false;
                    break;
                }
                fast = fast.next;
                slow = slow.next;
            }
        }

        return result;
    }

    public static ListNode reverseList(ListNode head) {
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

    }

}
