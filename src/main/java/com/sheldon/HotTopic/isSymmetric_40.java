package com.sheldon.HotTopic;

/**
 * 40. 对称的二叉树
 * 题目描述：给定一个二叉树，检查它是否是镜像对称的。
 * https://leetcode.cn/problems/symmetric-tree/submissions/518545364/?envType=study-plan-v2&envId=top-100-liked
 */

class isSymmetric_40 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isMirror(root.left, root.right);
    }

    boolean isMirror(TreeNode t1, TreeNode t2) {
        // 终止条件
        if (t1 == null && t2 == null) {
            return true;
        }
        // 单层逻辑
        if (t1 != null && t2 != null) {
            if (t1.val != t2.val) {
                return false;
            }
            return isMirror(t1.left, t2.right) && isMirror(t1.right, t2.left);
        }
        return false;
    }

    public static void main(String[] args) {
        isSymmetric_40 isSymmetric40 = new isSymmetric_40();
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(2);
        TreeNode leftLeft = new TreeNode(3);
        TreeNode leftRight = new TreeNode(4);
        TreeNode rightLeft = new TreeNode(4);
        TreeNode rightRight = new TreeNode(3);
        root.left = left;
        root.right = right;
        left.left = leftLeft;
        left.right = leftRight;
        right.left = rightLeft;
//        right.right = rightRight;
        System.out.println(isSymmetric40.isSymmetric(root));
    }

}