package com.sheldon.HotTopic;

import java.util.HashMap;
import java.util.Map;

/**
 * 560. 和为K的子数组
 * 给定一个整数数组和一个整数k，你需要找到该数组中和为k的连续的子数组的个数。
 * 链接：https://leetcode-cn.com/problems/subarray-sum-equals-k/
 */
class subarraySum_ {
    public int subarraySum(int[] nums, int k) {
        int result = 0;
        // 前缀和和出现次数的映射
        Map<Integer, Integer> prefixSumCount = new HashMap<>();
        prefixSumCount.put(0, 1);
        // 前缀和
        int prefixSum = 0;
        for (int num : nums) {
            prefixSum += num;
            // 如果存在前缀和为prefixSum - k的子数组，那么这个子数组的和为k
            if (prefixSumCount.containsKey(prefixSum - k)) {
                result += prefixSumCount.get(prefixSum - k);
            }
            prefixSumCount.put(prefixSum, prefixSumCount.getOrDefault(prefixSum, 0) + 1);
        }
        return result;
    }

    public static void main(String[] args) {
        subarraySum_ subarraySum = new subarraySum_();
        int[] nums = {1, 1, 1};
        int k = 2;
        System.out.println(subarraySum.subarraySum(nums, k));
    }
}