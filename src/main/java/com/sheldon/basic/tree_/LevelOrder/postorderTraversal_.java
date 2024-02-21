package com.sheldon.basic.tree_.LevelOrder;

import com.sheldon.basic.tree_.TreeNode;

import java.util.*;

/**
 * 二叉树的后序遍历
 *
 * @author sheldon
 */
class postorderTraversal_ {

    /**
     * 通用迭代实现 后序遍历
     * @param root
     * @return
     */
    public static List<Integer> postorderTraversal03(TreeNode root) {

        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) {
            return result;
        } else {
            stack.push(root);
        }
        while(!stack.isEmpty()) {
            // 遍历顺序： 左右中
            // 取出当前节点
            TreeNode cur = stack.pop();
            if (cur != null) {
                // 说明当前节点不是要处理的节点

                // 因为中间节点是要处理的节点
                stack.push(cur);
                // 作为标记
                stack.push(null);
                if (cur.right != null) {
                    stack.push(cur.right);
                }
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
     * 迭代实现 后序遍历
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal02(TreeNode root) {
        // 前序遍历 -> 中左右
        // 后序遍历 -> 左右中
        // 将前序遍历调整为 中右左，然后反转结果 -> 左右中
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            result.add(cur.val);
            if (cur.left != null) {
                stack.push(cur.left);
            }
            if(cur.right != null) {
                stack.push(cur.right);
            }
        }
        Collections.reverse(result);
        return result;
    }

    /**
     * 递归实现 后序遍历
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal(TreeNode root) {
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
        traversal(cur.left, result);
        traversal(cur.right, result);
        result.add(cur.val);
    }
}