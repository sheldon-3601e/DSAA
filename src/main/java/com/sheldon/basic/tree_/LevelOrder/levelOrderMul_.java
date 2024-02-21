package com.sheldon.basic.tree_.LevelOrder;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 给定一个 N 叉树，返回其节点值的层序遍历。（即从左到右，逐层遍历）。
 *
 * @author sheldon
 */
class levelOrderMul_ {

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            // 得到当前层级的节点数
            int size = queue.size();
            // 当前层级的节点结果
            List<Integer> temp = new ArrayList<>();
            // 遍历当前层级的所有节点
            for (int i = 0; i < size ; i++ ) {
                Node cur = queue.poll();
                temp.add(cur.val);
                // 遍历当前节点的所有子节点
                for (Node child : cur.children) {
                    queue.offer(child);
                }
            }
            result.add(temp);
        }
        return result;
    }
}