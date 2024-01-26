package com.sheldon.basic.LinkedList;

class MyLinkedListTest {

    public static void main(String[] args) {
        // 创建 MyLinkedList 对象
        MyLinkedList myLinkedList = new MyLinkedList();

        // 添加节点测试
        myLinkedList.addAtHead(1);
        myLinkedList.addAtHead(2);
        myLinkedList.addAtTail(3);
        myLinkedList.addAtTail(4);

        // 输出链表内容
        System.out.println("Linked List after adding nodes:");
        printLinkedList(myLinkedList);

        // 获取节点值测试
        int indexToGet = 2;
        int valueAtIndex = myLinkedList.get(indexToGet);
        System.out.println("Value at index " + indexToGet + ": " + valueAtIndex);

        // 在指定位置添加节点测试
        int indexToAdd = 2;
        int valueToAdd = 10;
        myLinkedList.addAtIndex(indexToAdd, valueToAdd);
        System.out.println("Linked List after adding node at index " + indexToAdd + ":");
        printLinkedList(myLinkedList);

        // 删除节点测试
        int indexToDelete = 3;
        myLinkedList.deleteAtIndex(indexToDelete);
        System.out.println("Linked List after deleting node at index " + indexToDelete + ":");
        printLinkedList(myLinkedList);
    }

    // 辅助方法：打印链表内容
    private static void printLinkedList(MyLinkedList myLinkedList) {
        MyLinkedList.Node current = myLinkedList.head;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}
