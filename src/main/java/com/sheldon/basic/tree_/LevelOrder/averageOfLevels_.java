package com.sheldon.basic.tree_.LevelOrder;

import com.sheldon.basic.tree_.TreeNode;
import sun.awt.image.ImageWatched;

import java.util.*;

/**
 * 给定一个非空二叉树的根节点 root , 以数组的形式返回每一层节点的平均值。与实际答案相差 10-5 以内的答案可以被接受。
 *
 * @author sheldon
 */

class averageOfLevels_ {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            // 得到当前层级的节点数
            int size = queue.size();
            // 当前层级的节点结果
             Double sum = 0.0;
            // 遍历当前层级的所有节点
            for (int i = 0; i < size ; i++ ) {
                TreeNode cur = queue.poll();
                // 获取当前层级的节点值总和
                sum += cur.val;
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            // 计算每个层级的平均值
            result.add(sum / size);
        }
        return result;
    }
}