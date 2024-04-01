package com.sheldon.HotTopic;

/**
 * 43. 将有序数组转换为二叉搜索树
 * 题目描述：给定一个有序数组，将其转换为一棵高度平衡的二叉搜索树。
 * 高度平衡二叉树是一棵每个节点的两个子树的深度差不超过 1 的二叉树。
 * https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree/
 */

class sortedArrayToBST_43 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return traversal( nums, 0, nums.length - 1);
    }

    TreeNode traversal(int[] nums, int start, int end) {
        // 终止条件
        if (start > end) {
            return null;
        }

        // 单层逻辑
        int index = start + (end - start) / 2;
        TreeNode root = new TreeNode(nums[index]);
        root.left = traversal(nums, start, index - 1);
        root.right = traversal(nums, index + 1, end);
        return root;
    }

    public static void main(String[] args) {
        sortedArrayToBST_43 sortedArrayToBST43 = new sortedArrayToBST_43();
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        TreeNode root = sortedArrayToBST43.sortedArrayToBST(nums);
        System.out.println(root.val);
    }
}