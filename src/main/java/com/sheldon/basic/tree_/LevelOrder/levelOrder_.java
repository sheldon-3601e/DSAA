package com.sheldon.basic.tree_.LevelOrder;

import com.sheldon.basic.tree_.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
 *
 * @author sheldon
 */
class levelOrder_ {

    /**
     * 递归实现
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder02(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root != null) {
            traverse(root, 0, result);
        }
        return result;
    }

    private void traverse(TreeNode node, int level, List<List<Integer>> result) {
        if (result.size() <= level) {
            result.add(new ArrayList<>());
        }
        result.get(level).add(node.val);
        if (node.left != null) {
            traverse(node.left, level + 1, result);
        }
        if (node.right != null) {
            traverse(node.right, level + 1, result);
        }
    }


    /**
     * 迭代实现
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder01(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            // 得到当前层级的节点数
            int size = queue.size();
            // 当前层级的节点结果
            List<Integer> temp = new ArrayList<>();
            // 遍历当前层级的所有节点
            for (int i = 0; i < size ; i++ ) {
                TreeNode cur = queue.poll();
                temp.add(cur.val);
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            result.add(temp);
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
        levelOrder_ levelOrder = new levelOrder_();
        List<List<Integer>> result = levelOrder.levelOrder02(root);
        System.out.println(result);
    }
}