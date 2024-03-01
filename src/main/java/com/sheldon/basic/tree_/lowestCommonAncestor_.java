package com.sheldon.basic.tree_;

class lowestCommonAncestor_ {
    /**
     * 236. 二叉树的最近公共祖先
     * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
     *
     * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，
     * 最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor01(TreeNode root, TreeNode p, TreeNode q) {
        if(root == p || root == q || root == null) {
            return root;
        }
        TreeNode left = lowestCommonAncestor01(root.left, p,q);
        TreeNode right = lowestCommonAncestor01(root.right, p,q);

        if(left != null && right != null) {
            return root;
        }

        if(left == null && right != null) {
            return right;
        } else if(left != null && right == null) {
            return left;
        } else {
            return null;
        }
    }

    /**
     * 235. 二叉搜索树的最近公共祖先
     * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
     *
     * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
     *
     * 例如，给定如下二叉搜索树:  root = [6,2,8,0,4,7,9,null,null,3,5]
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor02(TreeNode root, TreeNode p, TreeNode q) {

        if(root == null) {
            return root;
        }

        // 说明目标值在左区间
        if(root.val > p.val && root.val > q.val) {
            TreeNode left = lowestCommonAncestor02(root.left, p, q);
            if(left != null) {
                return left;
            }
        }
        // 目标值在右区间
        if(root.val < p.val && root.val < q.val) {
            TreeNode right = lowestCommonAncestor02(root.right, p, q);
            if(right != null) {
                return right;
            }
        }
        return root;
    }
}