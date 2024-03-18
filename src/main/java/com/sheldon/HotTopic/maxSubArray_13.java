package com.sheldon.HotTopic;

/**
 * 53. 最大子数组和
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 子数组是数组中的一个连续部分。
 *
 * 链接：https://leetcode.cn/problems/maximum-subarray/?envType=study-plan-v2&envId=top-100-liked
 */
class maxSubArray_13 {
    public int maxSubArray(int[] nums) {
        int result = Integer.MIN_VALUE;
        int count = 0;

        for (int num : nums) {
            // 累加数值
            count += num;
            // 更新结果
            if (count > result) {
                result = count;
            }
            // 重新计数
            if (count < 0) {
                count = 0;
            }
        }
        return result;
    }
}