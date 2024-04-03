package com.sheldon.HotTopic;

/**
 * 114. Flatten Binary Tree to Linked List
 * Given a binary tree, flatten it to a linked list in-place.
 * https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
 */

class flatten_47 {
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        while (root != null) {
            // 如果左子树为空，则直接跳过
            if (root.left != null) {
                // 存在左子树，则找到左子树的最右节点
                TreeNode rightMost = root.left;
                while (rightMost.right != null) {
                    rightMost = rightMost.right;
                }
                // 将右子树插入到左子树的最右节点
                rightMost.right = root.right;
                // 将左子树插入到右节点
                root.right = root.left;
                root.left = null;
            }
            root = root.right;
        }
    }
}