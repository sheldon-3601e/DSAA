package com.sheldon.basic.backTracking_;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 47. 全排列 II
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,1,2]
 * 输出：
 * [[1,1,2],
 *  [1,2,1],
 *  [2,1,1]]
 * 示例 2：
 *
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 *
 * 链接：https://leetcode-cn.com/problems/permutations-ii
 */
class permuteUnique_ {

    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    boolean[] used;

    public List<List<Integer>> permuteUnique(int[] nums) {
        used = new boolean[nums.length];
        Arrays.sort(nums);
        backtracking(nums);
        return result;
    }

    public void backtracking(int[] nums) {
        int size = nums.length;
        if (path.size() == size) {
            result.add(new ArrayList(path));
            return;
        }

        for (int i = 0; i < size; i++) {
            // 说明当前层级中已经使用过了
            if (i > 0 && nums[i - 1] == nums[i] && used[i - 1] == false) {
                continue;
            }
            // 说明当前节点还没有被使用
            if (used[i] == false) {
                used[i] = true;
                path.add(nums[i]);
                backtracking(nums);
                path.removeLast();
                used[i] = false;
            }

        }
    }
}