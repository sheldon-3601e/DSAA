package com.sheldon.HotTopic;

/**
 * Created by sheldon on 18-7-25.
 * 49. 路径总和 II
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 * 链接：https://leetcode-cn.com/problems/path-sum-ii/
 */

class pathSum_49 {

    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        return (int) (traversal(root, targetSum, 0L) + pathSum(root.left, targetSum) + pathSum(root.right, targetSum));
    }

    public static long traversal(TreeNode root, int targetSum, long currentSum) {
        if (root == null) {
            return 0L;
        }
        currentSum += root.val;
        long count = currentSum == targetSum ? 1 : 0;
        count += traversal(root.left, targetSum, currentSum);
        count += traversal(root.right, targetSum, currentSum);
        return count;
    }
}