package com.sheldon.HotTopic;

/**
 * 44. 验证二叉搜索树
 * 题目描述：给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 * 链接：https://leetcode-cn.com/problems/validate-binary-search-tree/
 */

class isValidBST_44 {

    // 记录前一个节点的值
    TreeNode prev = null;
    public boolean isValidBST(TreeNode root) {
        return traversal(root);
    }

    boolean traversal(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean left = traversal(root.left);
        if (prev != null && prev.val >= root.val) {
            return false;
        }
        prev = root;
        boolean right = traversal(root.right);
        return left && right;
    }
}