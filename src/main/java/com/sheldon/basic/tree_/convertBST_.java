package com.sheldon.basic.tree_;

/**
 * 538. 把二叉搜索树转换为累加树
 * 给出二叉 搜索 树的根节点，该树的节点值各不相同，请你将其转换为累加树（Greater Sum Tree），使每个节点 node 的新值等于原树中大于或等于 node.val 的值之和。
 *
 * 提醒一下，二叉搜索树满足下列约束条件：
 *
 * 节点的左子树仅包含键 小于 节点键的节点。
 * 节点的右子树仅包含键 大于 节点键的节点。
 * 左右子树也必须是二叉搜索树。
 * 注意：本题和 1038: https://leetcode-cn.com/problems/binary-search-tree-to-greater-sum-tree/ 相同
 * 理解为有序数组，从后往前遍历
 * [1,2,4] -> [7,6,4]
 * 对于二叉树来说，遍历顺序为 右 中 左
  */
class convertBST_ {

    // 用来记录上一个节点的值
    int pre;
    public TreeNode convertBST(TreeNode root) {
        pre = 0;
        traversal(root);
        return root;
    }

    void traversal(TreeNode root) {
        if(root == null) {
            return;
        }
        traversal(root.right);
        // 累加上一个节点的值
        root.val += pre;
        // 记录当前节点的值
        pre = root.val;

        traversal(root.left);
    }
}