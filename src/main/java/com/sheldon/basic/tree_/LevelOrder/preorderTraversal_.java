package com.sheldon.basic.tree_.LevelOrder;

import com.sheldon.basic.tree_.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树的前序遍历
 *
 * @author sheldon

 */

class preorderTraversal_ {

    /**
     * 通用迭代实现 前序遍历
     * @param root
     * @return
     */
    public static List<Integer> preorderTraversal03(TreeNode root) {

        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) {
            return result;
        } else {
            stack.push(root);
        }
        while(!stack.isEmpty()) {
            // 遍历顺序：中左右
            // 取出当前节点
            TreeNode cur = stack.pop();
            if (cur != null) {
                // 说明当前节点不是要处理的节点
                // 按照 左中右 的顺序压入栈
                if (cur.right != null) {
                    stack.push(cur.right);
                }
                if (cur.left != null) {
                    stack.push(cur.left);
                }
                // 因为中间节点是要处理的节点
                stack.push(cur);
                // 作为标记
                stack.push(null);
            } else {
                // 要处理的节点
                cur = stack.pop();
                result.add(cur.val);
            }
        }
        return result;

    }

    /**
     * 迭代实现 前序遍历
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal02(TreeNode root) {
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        List<Integer> res = new ArrayList<>();
        TreeNode cur = root;
        stack.push(cur);
        while(stack.isEmpty()) {
            cur = stack.pop();
            res.add(cur.val);
            stack.push(cur.right);
            stack.push(cur.left);
        }
        return res;
    }

    /**
     * 递归实现 前序遍历
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal01(TreeNode root) {
        // 确定递归的参数和返回值
        List<Integer> result = new ArrayList<>();
        traversal(root, result);
        return result;
    }

    public static void traversal(TreeNode cur, List<Integer> result) {
        // 确定终止条件
        if (cur == null) {
            return;
        }
        // 确定单层递归的逻辑
        result.add(cur.val);
        traversal(cur.left, result);
        traversal(cur.right, result);
    }


    public static void main(String[] args) {

    }

}