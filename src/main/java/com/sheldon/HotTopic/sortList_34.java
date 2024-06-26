package com.sheldon.HotTopic;

class sortList_34 {
    // 归并排序
    // 1. 找到链表的中间节点
    // 2. 递归地对两个子链表进行排序
    // 3. 合并两个排序后的子链表

    /**
     * 排序链表
     * @param head
     * @return
     */
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode mid = findMiddle(head);
        ListNode nextOfMid = mid.next;
        mid.next = null;

        ListNode left = sortList(head);
        ListNode right = sortList(nextOfMid);

        return merge(left, right);
    }

    /**
     * 找到链表的中间节点 - 快慢指针
     * @param head
     * @return
     */
    private ListNode findMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    /**
     * 合并两个排序后的子链表
     * @param l1
     * @param l2
     * @return
     */
    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }

        current.next = (l1 != null) ? l1 : l2;

        return dummy.next;
    }
}
