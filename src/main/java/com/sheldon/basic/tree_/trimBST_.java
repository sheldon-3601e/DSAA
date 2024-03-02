package com.sheldon.basic.tree_;

class trimBST_ {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if(root == null) {
            return null;
        }
        int val = root.val;
        // 当值小于最小值
        if(val < low) {
            // 在它的右节点的寻找符合要求的节点返回
            TreeNode rootRight = trimBST(root.right, low, high);
            return rootRight;
        }
        // 当值大于最大值
        if(val > high) {
            // 在它的左节点中寻找符合要求的节点返回
            TreeNode rootLeft = trimBST(root.left, low, high);
            return rootLeft;
        }
        // 承接返回值
        root.left = trimBST(root.left , low, high);
        root.right = trimBST(root.right , low, high);

        return root;
    }
}