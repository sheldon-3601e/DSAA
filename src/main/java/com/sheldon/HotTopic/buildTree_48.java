package com.sheldon.HotTopic;

import java.util.Arrays;

/**
 * Created by sheldon on 18-7-26.
 * 105. 从前序与中序遍历序列构造二叉树
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 * from: https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 */

class buildTree_48 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        // 递归构建树
        return tarversal(preorder, inorder);
    }

    public TreeNode tarversal(int[] preorder, int[] inorder) {
        // 说明为空
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        // 根节点
        int rootVal = preorder[0];
        TreeNode root = new TreeNode(rootVal);

        // 说明只有一个节点，即根节点
        if (preorder.length == 1) {
            return root;
        }

        // 寻找根节点在中序遍历中的位置
        int index = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == rootVal) {
                index = i;
                break;
            }
        }

        // 切割中序遍历
        int[] leftInorder = Arrays.copyOfRange(inorder, 0, index);
        int[] rightInorder = Arrays.copyOfRange(inorder, index + 1, inorder.length);

        // 切割前序遍历
        int[] leftPreorder = Arrays.copyOfRange(preorder, 1, leftInorder.length + 1);
        int[] rightPreorder = Arrays.copyOfRange(preorder, leftInorder.length + 1, preorder.length);

        // 递归构建左子树
        root.left = tarversal(leftPreorder, leftInorder);
        // 递归构建右子树
        root.right = tarversal(rightPreorder, rightInorder);

        return root;
    }
}