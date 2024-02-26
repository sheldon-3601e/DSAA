package com.sheldon.basic.tree_;

import lombok.val;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 513. 找树左下角的值
 * 给定一个二叉树的 根节点 root，请找出该二叉树的 最底层 最左边 节点的值。
 *
 * 假设二叉树中至少有一个节点。
 *
 * 示例 1:
 *
 * 输入: root = [2,1,3]
 * 输出: 1
 * 示例 2:
 *
 * 输入: [1,2,3,4,null,5,6,null,null,7]
 * 输出: 7
 *
 */

class findBottomLeftValue_ {
    public int findBottomLeftValue(TreeNode root) {
        int result = 0;
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.pop();
                if (i == 0) {
                    result = cur.val;
                }
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