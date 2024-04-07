package com.sheldon.HotTopic;

/**
 * 236. 二叉树的最近公共祖先
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * from: https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
 */

class lowestCommonAncestor_50 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 终止条件
        if (root == null || root == p || root == q) {
            return root;
        }

        // 后序遍历，回溯过程
        TreeNode leftNode = lowestCommonAncestor(root.left, p, q);
        TreeNode rightNode = lowestCommonAncestor(root.right, p, q);

        // 说明当前节点为最近公共祖先
        if (leftNode != null && rightNode != null) {
            return root;
        }

        if (leftNode != null && rightNode == null) {
            return leftNode;
        } else if (leftNode == null && rightNode != null) {
            return rightNode;
        } else {
            return null;
        }

    }
}