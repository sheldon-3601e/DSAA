package com.sheldon.basic.backTracking_;

import java.util.*;

/**
 * 491. 递增子序列
 * 给定一个整型数组，你的任务是找到所有该数组的递增子序列，递增子序列的长度至少是2。
 * <p>
 * 示例：
 * 输入：[4, 6, 7, 7]
 * 输出：[[4, 6], [4, 7], [4, 6, 7], [4, 6, 7, 7], [6, 7], [6, 7, 7], [7,7], [4,7,7]]
 * 提示：
 * 给定数组的长度不会超过15。
 * 数组中的整数范围是 [-100,100]。
 * 给定数组中可能包含重复数字，相等的数字可能会被组合成一个递增子序列。
 * 链接：https://leetcode-cn.com/problems/increasing-subsequences
 */
class findSubsequences_ {
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        backtracking(nums, 0);
        return result;
    }

    public void backtracking(int[] nums, int startIndex) {
        int size = nums.length;
        if (path.size() > 1) {
            result.add(new ArrayList(path));
        }
        if (startIndex >= size) {
            return;
        }

        Set<Integer> uset = new HashSet<>();
        for (int i = startIndex; i < size; i++) {
            // 条件验证有两个方面
            // 1. 如果当前元素小于path中的最后一个元素，说明当前元素已经在path中了，不需要再次添加
            // 2. 如果当前元素已经在uset中了，说明当前元素已经被使用过了，不需要再次添加
            if (!path.isEmpty() && nums[i] < path.getLast() || uset.contains(nums[i])) {
                continue;
            }
            uset.add(nums[i]);
            path.add(nums[i]);
            backtracking(nums, i + 1);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        findSubsequences_ findSubsequences = new findSubsequences_();
        int[] nums = {4, 4, 3, 2, 1};
        List<List<Integer>> subsequences = findSubsequences.findSubsequences(nums);
        System.out.println(subsequences);
    }
}