package com.sheldon.basic.stack_;

import java.util.*;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
public class inorderTraversal {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {
        }
        TreeNode(int val) {
            this.val = val;
        }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * 给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。<br>
     * 中序遍历（Inorder traversal）是一种用于遍历二叉树的方法。在中序遍历中，首先遍历左子树，然后访问根节点，最后遍历右子树。
     * @param root
     * @return
     */

    public List<Integer> inorderTraversal01(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        TreeNode current = root;

        while (current != null || !stack.isEmpty()) {
            // 将当前节点的左子树的节点依次入栈
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            // 当到达左子树的叶子节点时，开始出栈
            current = stack.pop();
            result.add(current.val);
            // 即开始回退节点，并访问上一个节点的右节点
            current = current.right;
        }

        return result;
    }

}