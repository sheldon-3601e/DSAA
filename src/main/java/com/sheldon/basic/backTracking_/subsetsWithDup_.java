package com.sheldon.basic.backTracking_;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 90. 子集 II
 * 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
 *
 * 解集 不能 包含重复的子集。返回的解集中不可以包含重复的子集。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,2]
 * 输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
 * 示例 2：
 *
 * 输入：nums = [0]
 * 输出：[[],[0]]
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 10
 * -10 <= nums[i] <= 10
 *
 * 链接：https://leetcode-cn.com/problems/subsets-ii
 */
class subsetsWithDup_ {
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    boolean[] used;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        used = new boolean[nums.length];
        backtracking(nums, 0);
        return result;
    }

    public void backtracking(int[] nums, int startIndex) {
        int size = nums.length;
        result.add(new ArrayList(path));
        if (startIndex >= size) {
            return;
        }

        for (int i = startIndex; i < size; i++) {
            // used[i - 1] == true，说明同一树枝candidates[i - 1]使用过
            //used[i - 1] == false，说明同一树层candidates[i - 1]使用过
            //同一树层，used[i - 1] == false 才能表示，当前取的 candidates[i] 是从 candidates[i - 1] 回溯而来的。
            //而 used[i - 1] == true，说明是进入下一层递归，去下一个数，
            if(i > 0 && nums[i - 1] == nums[i] && used[i - 1] == false ){
                continue;
            }
            path.add(nums[i]);
            used[i] = true;
            backtracking(nums, i + 1);
            used[i] = false;
            path.removeLast();
        }

    }

    public static void main(String[] args) {
        subsetsWithDup_ subsetsWithDup = new subsetsWithDup_();
        int[] nums = {1, 2, 2};
        List<List<Integer>> result = subsetsWithDup.subsetsWithDup(nums);
        System.out.println(result);
    }

}