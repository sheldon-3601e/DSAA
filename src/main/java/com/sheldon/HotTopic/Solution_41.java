package com.sheldon.HotTopic;

/**
 * 41. 二叉树的直径
 * 题目描述：给定一棵二叉树，你需要计算它的直径长度。
 * 一棵二叉树的直径长度是任意两个结点路径长度中的最大值。
 * 这条路径可能穿过也可能不穿过根结点。
 * https://leetcode-cn.com/problems/diameter-of-binary-tree/
 */

class maxPathLength_41 {

    private int maxPathLength = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        traversal(root);
        return maxPathLength;
    }

    int traversal(TreeNode root) {
        // 终止条件
        if (root == null) {
            return 0;
        }
        // 单层逻辑
        // 分别递归左右子树，计算左右子树的深度
        int leftDepth = traversal(root.left);
        int rightDepth = traversal(root.right);

        // 更新maxPathLength
        // 左右子树的深度之和即为当前节点的最大路径长度
        maxPathLength = Math.max(maxPathLength, leftDepth + rightDepth);

        return Math.max(leftDepth, rightDepth) + 1;
    }
}