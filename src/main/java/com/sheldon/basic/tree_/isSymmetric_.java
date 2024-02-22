package com.sheldon.basic.tree_;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

class isSymmetric_ {
    /**
     * 迭代实现
     * @param root
     * @return
     */
    public boolean isSymmetric02(TreeNode root) {

        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);
        while (!queue.isEmpty()) {
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();
            if (left == null && right == null) {
                continue;
            }
            if (left == null || right == null || left.val != right.val) {
                return false;
            }
            queue.offer(left.left);
            queue.offer(right.right);
            queue.offer(left.right);
            queue.offer(right.left);
        }
        return true;
    }

    /**
     * 试用递归实现
     * @param root
     * @return
     */
    public boolean isSymmetric01(TreeNode root) {
        // 要判断左右节点是否互为反转
        return traverse(root.left, root.right);
    }

    public static boolean traverse(TreeNode left, TreeNode right) {
        // 判断是否为空的情况
        if (left == null && right != null) {
            return false;
        } else if (left != null && right == null) {
            return false;
        } else if (left == null && right == null) {
            return true;
        } else if (left.val != right.val) {
            return false;
        }
        // 左右节点都不为空，且值相等
        boolean res1 = traverse(left.left, right.right);
        boolean res2 = traverse(left.right, right.left);

        return res1 && res2;
    }
}