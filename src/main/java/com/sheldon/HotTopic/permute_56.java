package com.sheldon.HotTopic;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sheldon
 * 46. 全排列
 * https://leetcode.cn/problems/permutations
 */

class permute_56 {

    List<List<Integer>> res;
    List<Integer> path;

    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) {
            return res;
        }

        res = new ArrayList<>();
        path = new ArrayList<>();
        boolean[] isUsed = new boolean[nums.length];
        traverse(nums, isUsed);
        return res;

    }

    void traverse(int[] nums, boolean[] isUsed) {

        // 终止条件
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // 排除重复
            if (!isUsed[i]){
                // 回溯
                isUsed[i] = true;
                path.add(nums[i]);
                traverse(nums, isUsed);
                path.remove(path.size() - 1);
                isUsed[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        permute_56 permute56 = new permute_56();
        List<List<Integer>> res = permute56.permute(nums);
        for (List<Integer> list : res) {
            System.out.println(list);
        }
    }
}