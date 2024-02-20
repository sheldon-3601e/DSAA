package com.sheldon.basic.tree_;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;


class preorderTraversal_ {

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