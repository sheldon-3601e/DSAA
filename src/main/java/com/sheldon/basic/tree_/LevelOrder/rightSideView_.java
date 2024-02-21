package com.sheldon.basic.tree_.LevelOrder;

import com.sheldon.basic.tree_.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 *
 * @author sheldon
 */
class rightSideView_ {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            // 得到当前层级的节点数
            int size = queue.size();
            // 当前层级的节点结果
            TreeNode cur = null;
            // 遍历当前层级的所有节点
            for (int i = 0; i < size ; i++ ) {
                cur = queue.poll();
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            // 将每层的最后一个元素加入结果集
            result.add(cur.val);
        }
        return result;
    }
}