package com.sheldon.HotTopic;

class maxPathSum_51 {

    private int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        traversal(root);
        return maxSum;
    }

    private int traversal(TreeNode root) {
        if (root == null) {
            return 0;
        }

        // 可能存在的情况，bac，其中a为根节点
        // b + a + c。
        // b + a + a 的父结点。
        // a + c + a 的父结点。

        int leftNum = Math.max(traversal(root.left), 0);
        int rightNum = Math.max(traversal(root.right), 0);
        int curSum = root.val + leftNum + rightNum;
        // 更新最大值
        maxSum = Math.max(maxSum, curSum);

        // 返回左子树和右子树的最大路径和中的较大者
        return root.val + Math.max(leftNum, rightNum);
    }
}