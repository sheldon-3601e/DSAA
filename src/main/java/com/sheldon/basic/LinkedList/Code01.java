package com.sheldon.basic.LinkedList;

/**
 * @ClassName Code01
 * @Author 26483
 * @Date 2024/1/27 9:17
 * @Version 1.0
 * @Description TODO
 */
public class Code01 {
    /**
     * 给你一个链表的头节点 head ，判断链表中是否有环。
     *
     * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。注意：pos 不作为参数进行传递 。仅仅是为了标识链表的实际情况。
     *
     * 如果链表中存在环，则返回 true 。 否则，返回 false 。
     *
     * 示例 1：
     *
     * 输入：head = [3,2,0,-4], pos = 1
     * 输出：true
     * 解释：链表中有一个环，其尾部连接到第二个节点。
     *
     * @param head
     * @return
     *
     * 解题思路：涉及到链表的问题，一般都是用双指针来解决 -> 快慢指针
     * 慢指针前进一步，快指针前进两步，如果有环，快指针一定会追上慢指针
     */

    public boolean hasCycle(ListNode head) {
        // 边界条件判断
        if (head == null || head.next == null) {
            return false;
        }
        // 定义快慢指针
        ListNode slow = head;
        ListNode fast = head.next;
        // 当快指针不为空时，进行循环
        while (fast != null && fast.next != null) {
            // 如果快指针追上了慢指针，说明有环
            if (fast.next == slow) {
                return true;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }

    public static void main(String[] args) {
        // 测试上面的方法
        Code01 code01 = new Code01();
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        head.next = node1;
        ListNode node2 = new ListNode(3);
        node1.next = node2;
        ListNode node3 = new ListNode(4);
        node2.next = node1;
        System.out.println(code01.hasCycle(head));
    }
}
