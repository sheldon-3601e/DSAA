package com.sheldon.HotTopic;

import java.util.Arrays;

/**
 * 41. 缺失的第一个正数
 * 给你一个未排序的整数数组，请你找出其中没有出现的最小的正整数。
 * 链接：https://leetcode-cn.com/problems/first-missing-positive/
 */
class FirstMissingPositive_17 {
    public int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);
        int result = 1;
        for (int num : nums) {
            if (num == result) {
                result++;
            }
        }
        return result;
    }
}