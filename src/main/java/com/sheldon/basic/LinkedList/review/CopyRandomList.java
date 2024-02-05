package com.sheldon.basic.LinkedList.review;

import java.util.HashMap;

/**
 * @ClassName CopyRandomList
 * @Author 26483
 * @Date 2024/2/3 1:56
 * @Version 1.0
 * @Description TODO
 */
public class CopyRandomList {

    /**
     * 给你一个长度为 n 的链表，每个节点包含一个额外增加的随机指针 random ，该指针可以指向链表中的任何节点或空节点。
     *
     * 构造这个链表的 深拷贝。 深拷贝应该正好由 n 个 全新 节点组成，其中每个新节点的值都设为其对应的原节点的值。新节点的 next 指针和 random 指针也都应指向复制链表中的新节点，并使原链表和复制链表中的这些指针能够表示相同的链表状态。复制链表中的指针都不应指向原链表中的节点 。
     *
     * 例如，如果原链表中有 X 和 Y 两个节点，其中 X.random --> Y 。那么在复制链表中对应的两个节点 x 和 y ，同样有 x.random --> y 。
     *
     * 返回复制链表的头节点。
     *
     * 用一个由 n 个节点组成的链表来表示输入/输出中的链表。每个节点用一个 [val, random_index] 表示：
     *
     * val：一个表示 Node.val 的整数。
     * random_index：随机指针指向的节点索引（范围从 0 到 n-1）；如果不指向任何节点，则为  null 。
     * 你的代码 只 接受原链表的头节点 head 作为传入参数。
     *
     */

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        // 创建一个map，key是原链表的节点，value是新链表的节点
        HashMap<Node, Node> map = new HashMap<>();
        Node cur = head;
        while (cur != null) {
            // 先不要管next和random指针，只复制节点值
            Node newNode = new Node(cur.val);
            map.put(cur, newNode);
            cur = cur.next;
        }
        // 现在得到一个map
        // 我们可以通过原链表的节点，找到新链表的节点
        // 从而设置next和random指针
        for (Node item : map.keySet()) {
            Node temp = map.get(item);
            temp.next = map.get(item.next);
            temp.random = map.get(item.random);
        }
        // 返回新链表的头节点
        return map.get(head);
    }

    public static void main(String[] args) {
        Node head = new Node(7);
        Node node1 = new Node(13);
        Node node2 = new Node(11);
        Node node3 = new Node(10);
        Node node4 = new Node(1);
        head.next = node1;
        head.random = null;
        node1.next = node2;
        node1.random = head;
        node2.next = node3;
        node2.random = node4;
        node3.next = node4;
        node3.random = node2;
        node4.next = null;
        node4.random = head;
        CopyRandomList copyRandomList = new CopyRandomList();
        Node node = copyRandomList.copyRandomList(head);
        // 判断两个链表是否相等

    }

}
