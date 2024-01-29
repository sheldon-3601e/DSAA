package com.sheldon.basic.LinkedList;

/**
 * @ClassName Code02
 * @Author 26483
 * @Date 2024/1/27 9:50
 * @Version 1.0
 *  
 */
public class Code02 {
    /**
     * 给定一个链表的头节点  head ，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
     * <p>
     * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
     * <p>
     * 不允许修改 链表。
     * <p>
     * 示例 1：
     * <p>
     * 输入：head = [3,2,0,-4], pos = 1
     * 输出：返回索引为 1 的链表节点
     * 解释：链表中有一个环，其尾部连接到第二个节点。
     *
     * @param head
     * @return
     * 解题思路：涉及到链表的问题，一般都是用双指针来解决 -> 快慢指针
     * <p>
     * 假设链表头到环的入口距离为 a，环的入口到相遇点的距离为 b，相遇点到环的入口的距离为 c，环的周长为 L。
     * <p>
     * 当快指针和慢指针相遇时，慢指针移动的距离为 a + b，快指针移动的距离为 a + b + n*L，其中 n 为快指针在环中转了 n 圈后与慢指针相遇。
     * <p>
     * 由于快指针的速度是慢指针的两倍，所以 2(a + b) = a + b + n*L，得到 a + b = n * L。
     * <p>
     * 此时吗，快慢指针都停留在相遇点，让慢指针重新指向头节点 head，快指针不动，
     * <p>
     * 然后快慢指针同时移动，每次移动一步，那么当慢指针移动了 a + b 步之后，快指针移动了 n * L（即还停留在原地），
     * <p>
     * 即快指针也到达了环的入口，两个指针相遇的节点即为环的入口节点。
     * <p>
     */

    public ListNode detectCycle(ListNode head) {
        // 边界条件判断
        if (head != null && head.next != null) {// 定义快慢指针
            ListNode slow = head;
            ListNode fast = head;// 当快指针不为空时，进行循环
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;

                // 如果快指针追上了慢指针，说明有环
                if (fast == slow) {
                    break;
                }
            }
            if (fast != null && fast.next != null) {
                slow = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }

        return null;
    }

    public static void main(String[] args) {
        // 测试上面的方法
        Code02 code02 = new Code02();
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        head.next = node1;
        ListNode node2 = new ListNode(3);
        node1.next = node2;
        ListNode node3 = new ListNode(4);
        node2.next = node1;
        ListNode listNode = code02.detectCycle(head);
        System.out.println(listNode.val);
        // 输出预计结果：2
    }

}
