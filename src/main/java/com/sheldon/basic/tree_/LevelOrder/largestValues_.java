package com.sheldon.basic.tree_.LevelOrder;

import com.sheldon.basic.tree_.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

class largestValues_ {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            // 得到当前层级的节点数
            int size = queue.size();
            // 当前层级的最大值
            int max = Integer.MIN_VALUE;
            // 遍历当前层级的所有节点
            for (int i = 0; i < size ; i++ ) {
                TreeNode cur = queue.poll();
                if (cur.val > max) {
                    max = cur.val;
                }
                // 遍历当前节点的所有子节点
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            result.add(max);
        }
        return result;
    }
}