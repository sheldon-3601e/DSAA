package com.sheldon.basic.tree_;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 给定二叉树的根节点 root ，返回所有左叶子之和。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入: root = [3,9,20,null,null,15,7]
 * 输出: 24
 * 解释: 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
 */

class sumOfLeftLeaves_ {

    /**
     * 递归遍历
     */
    public int sumOfLeftLeaves(TreeNode root) {
        // 确定终止条件
        if (root == null) {
            return 0;
        }
        // 确定单层逻辑
        int result = 0;
        if (root.left != null) {
            if (root.left.left == null && root.left.right == null) {
                result += root.left.val;
            } else {
                // 左子页中的左叶子节点
                result += sumOfLeftLeaves(root.left);
            }
        }
        // 右子叶中的左叶子节点
        if (root.right != null) {
            result += sumOfLeftLeaves(root.right);
        }
        return result;
    }

    /**
     * 层序遍历
     * @param root
     * @return
     */
    public int sumOfLeftLeaves01(TreeNode root) {
        int result = 0;
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i< size; i++) {
                TreeNode cur = queue.pop();
                TreeNode left = cur.left;
                if(left != null && left.left == null && left.right == null) {
                    result += left.val;
                }
                if(cur.left != null) {
                    queue.offer(left);
                }
                if(cur.right != null) {
                    queue.offer(cur.right);
                }
            }

        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode left = new TreeNode(9);
        TreeNode right = new TreeNode(20);
        TreeNode rightLeft = new TreeNode(15);
        TreeNode rightRight = new TreeNode(7);
        root.left = left;
        root.right = right;
        right.left = rightLeft;
        right.right = rightRight;
        sumOfLeftLeaves_ s = new sumOfLeftLeaves_();
        System.out.println(s.sumOfLeftLeaves(root));
    }
}