package com.sheldon.HotTopic;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 199. 二叉树的右视图
 * 给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 * 链接：https://leetcode-cn.com/problems/binary-tree-right-side-view/
 */

class rightSideView_46 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            TreeNode cur = null;
            for (int i = 0; i < size; i++) {
                cur = queue.poll();
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            result.add(cur.val);
        }
        return result;
    }

    public static void main(String[] args) {
        // 示例

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(4);

        rightSideView_46 rightSideView46 = new rightSideView_46();
        List<Integer> result = rightSideView46.rightSideView(root);
        System.out.println(result);

    }
}