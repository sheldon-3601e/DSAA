package com.sheldon.basic.LinkedList;

/**
 * @ClassName Utils
 * @Author 26483
 * @Date 2024/1/29 10:25
 * @Version 1.0
 *  
 */
public class Utils {

    // 遍历链表
    public static void printLinkedList(ListNode head) {
        System.out.print("Linked List: ");
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

}
