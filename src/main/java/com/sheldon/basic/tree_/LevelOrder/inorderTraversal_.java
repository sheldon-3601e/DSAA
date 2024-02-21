package com.sheldon.basic.tree_.LevelOrder;

import com.sheldon.basic.tree_.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。
 *
 * @author sheldon
 */
class inorderTraversal_ {

    /**
     * 通用迭代实现 中序遍历
     * @param root
     * @return
     */
    public static List<Integer> inorderTraversal03(TreeNode root) {

        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) {
            return result;
        } else {
            stack.push(root);
        }
        while(!stack.isEmpty()) {
            // 取出当前节点
            TreeNode cur = stack.pop();
            if (cur != null) {
                // 说明当前节点不是要处理的节点
                // 按照 左中右 的顺序压入栈
                if (cur.right != null) {
                    stack.push(cur.right);
                }
                // 因为中间节点是要处理的节点
                stack.push(cur);
                // 作为标记
                stack.push(null);
                if (cur.left != null) {
                    stack.push(cur.left);
                }
            } else {
                // 要处理的节点
                cur = stack.pop();
                result.add(cur.val);
            }
        }
        return result;

    }

    /**
     * 迭代实现 中序遍历
     * @param root
     * @return
     */
    public static List<Integer> inorderTraversal02(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        // 栈用来处理元素
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        // 指针用来访问底层元素
        TreeNode cur = root;
        while(cur != null || !stack.isEmpty()) {
            if (cur != null) {
                // 说明没有访问到最底层，
                // 添加到栈
                stack.push(cur);
                // 继续向左遍历
                cur = cur.left;
            } else {
                // 说明已经遍历到最左边，开始处理栈中元素
                // 获取当前要处理的节点
                cur = stack.pop();
                result.add(cur.val);
                // 开始遍历当前节点的右边
                cur = cur.right;
            }
        }
        return result;
    }

    /**
     * 递归实现 中序遍历
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            res.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));
        for (Integer i : inorderTraversal02(treeNode)) {
            System.out.println(i);
        }

    }
}