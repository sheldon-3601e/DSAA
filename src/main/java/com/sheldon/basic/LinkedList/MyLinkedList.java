package com.sheldon.basic.LinkedList;

class MyLinkedList {

    // 节点类
    public class Node {
        int val; // 节点的值
        Node next; // 下一个节点的引用

        // 节点构造函数
        Node(int val) {
            this.val = val;
        }
    }

    // 代表当前链表的长度
    public int size;

    // 代表链表的头结点
    public Node head;

    public MyLinkedList() {
        this.size = 0;
        this.head = null;
    }

    // 获取链表中第 index 个节点的值。如果索引无效，则返回-1。
    public int get(int index) {
        // 如果索引无效，则返回-1。
        if (index >= size || index < 0) {
            return -1;
        }
        // 从头结点开始遍历，直到第 index 个节点
        Node current = this.head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.val;
    }

    // 在链表的头部添加一个节点
    public void addAtHead(int val) {
        // 创建新节点，指向当前的头结点
        Node newNode = new Node(val);
        // 将头结点更新为新节点
        newNode.next = this.head;
        this.head = newNode;
        this.size++;
    }

    // 在链表的尾部添加一个节点
    public void addAtTail(int val) {
        if(this.head == null) {
            addAtHead(val);
            return;
        }

        Node newNode = new Node(val);
        Node current = this.head;
        // 遍历链表，直到最后一个节点
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
        this.size++;
    }

    public void addAtIndex(int index, int val) {

        if (index < 0 || index > size) {
            return;
        }
        if (index == 0) {
            addAtHead(val);
            return;
        }
        if (index == size) {
            addAtTail(val);
            return;
        }

        Node newNode = new Node(val);
        Node prev = null;
        Node current = this.head;
        // // 找到要插入位置的前一个节点
        for (int i = 0; i < index; i++) {
            prev = current;
            current = current.next;
        }
        prev.next = newNode;
        newNode.next = current;
        size++;
    }

    public void deleteAtIndex(int index) {

        if (index < 0 || index >= size) {
            return;
        }
        if (index == 0) {
            this.head = this.head.next;
            this.size--;
            return;
        }

        Node prev = null;
        Node current = this.head;
        // 找到要删除节点的前一个节点
        for (int i = 0; i < index; i++) {
            prev = current;
            current = current.next;
        }
        prev.next = current.next;
        this.size--;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */