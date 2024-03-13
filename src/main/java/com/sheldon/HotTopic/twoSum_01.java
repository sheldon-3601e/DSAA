package com.sheldon.HotTopic;

import java.util.HashMap;
import java.util.Map;

/**
 * 1. 两数之和
 * 链接：https://leetcode-cn.com/problems/two-sum/
 */
class twoSum_01 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = target - nums[i];
            // 如果 map 中存在 num 这个 key，那么直接返回
            if (map.containsKey(num)) {
                return new int[]{map.get(num), i};
            }
            // 不存在，就把当前的添加到 map 中
            map.put(nums[i], i);
        }
        return new int[0];
    }
}