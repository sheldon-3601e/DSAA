package com.sheldon.basic.tree_.LevelOrder;


import java.util.ArrayDeque;
import java.util.Queue;

class connect_ {


    // Definition for a Node.
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    public Node connect(Node root) {
        if (root == null) {
            return root;
        }
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            // 得到当前层级的节点数
            int size = queue.size();
            Node preNode = null;
            // 遍历当前层级的所有节点
            for (int i = 0; i < size; i++) {
                if (i == 0) {
                    preNode = queue.poll();
                } else {
                    preNode.next = queue.poll();
                    preNode = preNode.next;
                }
                if (preNode.left != null) {
                    queue.offer(preNode.left);
                }
                if (preNode.right != null) {
                    queue.offer(preNode.right);
                }
            }
        }
        return root;
    }

    public static void main(String[] args) {
        connect_ connect_ = new connect_();
        Node node = connect_.new Node(1);
        node.left = connect_.new Node(2);
        node.right = connect_.new Node(3);
        node.left.left = connect_.new Node(4);
        node.left.right = connect_.new Node(5);
        node.right.left = connect_.new Node(6);
        node.right.right = connect_.new Node(7);
        connect_.connect(node);
    }


}