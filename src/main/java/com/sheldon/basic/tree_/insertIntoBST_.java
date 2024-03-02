package com.sheldon.basic.tree_;

/**
 * 701. 二叉搜索树中的插入操作
 * 给定二叉搜索树（BST）的根节点 root 和要插入树中的值 value ，将值插入二叉搜索树。 返回插入后二叉搜索树的根节点。 输入数据 保证 ，新值和原始二叉搜索树中的任意节点值都不同。
 *
 * 注意，可能存在多种有效的插入方式，只要树在插入后仍保持为二叉搜索树即可。 你可以返回 任意有效的结果 。
 */
class insertIntoBST_ {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        // 即找到要插入的子节点
        // 返回要插入的新节点
        if(root == null) {
            return new TreeNode(val);
        }

        // 通过 二叉搜索树的有序性，判断方向
        // 通过返回值，承接要插入的新节点
        if(val > root.val) {
            root.right = insertIntoBST(root.right, val);
        }
        if(val < root.val) {
            root.left = insertIntoBST(root.left, val);
        }

        return root;
    }
}