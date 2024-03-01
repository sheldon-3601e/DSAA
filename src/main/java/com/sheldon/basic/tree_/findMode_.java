package com.sheldon.basic.tree_;

import java.util.ArrayList;

/**
 * 501. 二叉搜索树中的众数
 * 给你一个含重复值的二叉搜索树（BST）的根节点 root ，找出并返回 BST 中的所有 众数（即，出现频率最高的元素）。
 * <p>
 * 如果树中有不止一个众数，可以按 任意顺序 返回。
 * <p>
 * 假定 BST 满足如下定义：
 * <p>
 * 结点左子树中所含节点的值 小于等于 当前节点的值
 * 结点右子树中所含节点的值 大于等于 当前节点的值
 * 左子树和右子树都是二叉搜索树
 */
class findMode_ {
    // 结果集
    ArrayList<Integer> resList;
    // 最大计数
    int maxCount;
    // 当前计数
    int count;
    // 前一个节点
    TreeNode pre;

    public int[] findMode(TreeNode root) {
        resList = new ArrayList<>();
        maxCount = 0;
        count = 0;
        pre = null;
        traversal(root);
        int[] res = new int[resList.size()];
        for (int i = 0; i < resList.size(); i++) {
            res[i] = resList.get(i);
        }
        return res;
    }

    void traversal(TreeNode root) {
        if (root == null) {
            return;
        }
        // 中序遍历
        traversal(root.left);

        // 单层逻辑
        if (pre == null || pre.val != root.val) {
            // 说明 首个节点 或者 不同节点
            // 重置count
            count = 1;
        } else {
            // 说明相同节点
            count++;
        }

        // 更新结果以及maxCount
        if (count > maxCount) {
            // 说明当前节点的count大于maxCount
            // 即之前的众数作废，当前的节点为新的众数
            // 重置resList
            resList.clear();
            // 添加当前节点
            resList.add(root.val);
            // 更新maxCount
            maxCount = count;
        } else if (count == maxCount) {
            // 说明当前节点也是众数
            resList.add(root.val);
        }
        // 更新前一个节点值
        pre = root;
        traversal(root.right);
    }
}