package com.sheldon.basic.tree_;

/**
 * 翻转一棵二叉树。
 */
class invertTree_ {

    /**
     * 递归实现
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        traverse(root);
        return root;
    }

    public void traverse(TreeNode cur) {
        if (cur == null) {
            return;
        }
        TreeNode temp = cur.left;
        cur.left = cur.right;
        cur.right = temp;
        traverse(cur.right);
        traverse(cur.left);
    }
}