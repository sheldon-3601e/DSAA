package com.sheldon.basic.LinkedList;

class MyDoubleLinkedList {

    // 节点类
    public class DoubleListNode {
        int val; // 节点的值
        DoubleListNode next; // 下一个节点的引用
        DoubleListNode prev; // 上一个节点的引用

        // 节点构造函数
        DoubleListNode(int val) {
            this.val = val;
        }
    }

    // 代表当前链表的长度
    public int size;

    // 代表链表的头结点
    public DoubleListNode head;

    public MyDoubleLinkedList() {
        this.size = 0;
        this.head = null;
    }

    // 获取链表中第 index 个节点的值。如果索引无效，则返回-1。
    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }
        DoubleListNode cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.val;
    }

    // 在链表的头部添加一个节点
    public void addAtHead(int val) {
        DoubleListNode newNode = new DoubleListNode(val);
        if (head != null) {
            newNode.next = head;
            head.prev = newNode;
        }
        head = newNode;
        size++;
    }

    // 在链表的尾部添加一个节点
    public void addAtTail(int val) {
        if (head == null) {
            head = new DoubleListNode(val);
            size++;
            return;
        }
        DoubleListNode cur = head;
        while (cur.next != null) {
            cur = cur.next;
        }
        // 当前cur为最后一个节点
        DoubleListNode newNode = new DoubleListNode(val);
        cur.next = newNode;
        newNode.prev = cur;
        size++;
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
        DoubleListNode newNode = new DoubleListNode(val);
        // 找到要插入位置前的一个节点
        DoubleListNode cur = getIndexPrev(head, index);
        // 创建新节点
        DoubleListNode next = cur.next;
        cur.next = newNode;
        newNode.prev = cur;
        newNode.next = next;
        next.prev = newNode;
        size++;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        if (index == 0) {
            head = head.next;
            if (head != null){
                head.prev = null;
            }
        } else {
            DoubleListNode cur = getIndexPrev(head, index);
            DoubleListNode del = cur.next;
            cur.next = del.next;
            if (del.next != null) {
                del.next.prev = cur;
            }
        }
        size--;
    }

    private DoubleListNode getIndexPrev(DoubleListNode head, int index) {
        DoubleListNode cur = head;
        for (int i = 0; i < index - 1; i++) {
            cur = cur.next;
        }
        return cur;
    }
}

class Test {
    public static void main(String[] args) {
        MyDoubleLinkedList linkedList = new MyDoubleLinkedList();
        linkedList.addAtHead(1);
        linkedList.addAtTail(3);
        linkedList.addAtIndex(1, 2); // 链表变为1-> 2-> 3
        // 遍历链表
        for (int i = 0; i < linkedList.size; i++) {
            System.out.print(linkedList.get(i) + ",");
        }
        System.out.println();
        System.out.println(linkedList.get(1)); // 返回2
        linkedList.deleteAtIndex(1); // 现在链表是1-> 3
        System.out.println(linkedList.get(1)); // 返回3
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