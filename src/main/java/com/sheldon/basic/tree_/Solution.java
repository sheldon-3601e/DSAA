package com.sheldon.basic.tree_;

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if(root == null) {
            return root;
        }

        // 说明目标值在左区间
        if(root.val > p.val && root.val > q.val) {
            TreeNode left = lowestCommonAncestor(root.left, p, q);
            if(left != null) {
                return left;
            }
        }
        // 目标值在右区间
        if(root.val < p.val && root.val < q.val) {
            TreeNode right = lowestCommonAncestor(root.right, p, q);
            if(right != null) {
                return right;
            }
        }
        return root;
    }

    
}