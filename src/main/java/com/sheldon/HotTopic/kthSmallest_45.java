package com.sheldon.HotTopic;


/**
 * 45. 二叉搜索树中第K小的元素
 * 题目描述：给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素。
 * https://leetcode-cn.com/problems/kth-smallest-element-in-a-bst/
 */

class kthSmallest_45 {

    int index = 1;

    public int kthSmallest(TreeNode root, int k) {
        return traversal(root, k);
    }

    int traversal(TreeNode root, int nums) {
        if (root == null) {
            return -1;
        }
        int leftVal = traversal(root.left, nums);
        if (leftVal != -1) {
            return leftVal;
        }
        if (index == nums) {
            return root.val;
        }
        index++;
        return traversal(root.right, nums);
    }

    public static void main(String[] args) {
        kthSmallest_45 kthSmallest45 = new kthSmallest_45();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.right = new TreeNode(2);
        System.out.println(kthSmallest45.kthSmallest(root, 1));
    }
}