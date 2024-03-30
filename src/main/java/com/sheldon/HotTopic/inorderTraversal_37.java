package com.sheldon.HotTopic;

import java.util.ArrayList;
import java.util.List;

/**
 * 94. 二叉树的中序遍历
 * 给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。
 * 链接： https://leetcode.cn/problems/binary-tree-inorder-traversal/description/?envType=study-plan-v2&envId=top-100-liked
 */

class inorderTraversal_37 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        traversal(root, list);
        return list;
    }

    // 1. 确定参数及返回值
    void traversal(TreeNode root, List<Integer> list) {
        // 2. 确定终止条件
        if (root == null) {
            return;
        }
        // 3. 确认单层递归逻辑
        traversal(root.left, list);
        list.add(root.val);
        traversal(root.right, list);
    }
}

