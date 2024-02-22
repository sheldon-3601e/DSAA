package com.sheldon.basic.tree_;

class maxDepth_ {
    public int maxDepth(TreeNode root) {
        return traverse(root);
    }

    public static int traverse(TreeNode cur) {
        if (cur == null) {
            return 0;
        }
        int leftDepth = traverse(cur.left);
        int rightDepth = traverse(cur.right);
        return 1 + Math.max(leftDepth, rightDepth);
    }
}