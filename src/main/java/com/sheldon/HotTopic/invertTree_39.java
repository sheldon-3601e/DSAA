package com.sheldon.HotTopic;

/**
 * 226. 翻转二叉树
 * 给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
 * 链接：https://leetcode.cn/problems/invert-binary-tree/description/?envType=study-plan-v2&envId=top-100-liked
 */

class invertTree_39 {
    public TreeNode invertTree(TreeNode root) {
        traversal(root);
        return root;
    }

    void traversal(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        traversal(root.left);
        traversal(root.right);
    }
}