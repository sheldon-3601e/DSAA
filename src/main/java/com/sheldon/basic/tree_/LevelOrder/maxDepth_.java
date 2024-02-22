package com.sheldon.basic.tree_.LevelOrder;

import com.sheldon.basic.tree_.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 给定一个二叉树，找出其最大深度。
 */
class maxDepth_ {
    public int maxDepth(TreeNode root) {
        int result = 0;
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            // 得到当前层级的节点数
            int size = queue.size();
            // 当前层级的节点结果
            result++;
            // 遍历当前层级的所有节点
            for (int i = 0; i < size ; i++ ) {
                TreeNode cur = queue.poll();
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
        }
        return result;
    }
}