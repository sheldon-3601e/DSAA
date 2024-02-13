package com.sheldon.basic.searchTable;

import java.util.HashMap;
import java.util.Map;

class fourSumCount {
    public int fourSumCount01(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        // 记录可能的结果
        int count = 0;
        // 存储键值对
        // key - 数值， val - 出现的次数
        Map<Integer, Integer> map = new HashMap<>();

        // 遍历前两个数组，存储可能的结果
        for (int num1 : nums1 ) {
            for (int num2 : nums2 ) {
                int sum = num1 + num2;
                // 记录每一个结果出现的次数
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }

        for (int num3 : nums3 ) {
            for (int num4 : nums4 ) {
                int temp = - (num3 + num4);
                // 判断 map 中是否存在符合的值
                if (map.containsKey(temp)) {
                    // 如果存在，取出出现的次数，累加到结果中
                    count += map.get(temp);
                }
                
            }
        }

        return count;
    }

    public static void main(String[] args) {
        fourSumCount fourSumCount = new fourSumCount();
        int[] nums1 = {1, 2};
        int[] nums2 = {-2, -1};
        int[] nums3 = {-1, 2};
        int[] nums4 = {0, 2};
        System.out.println(fourSumCount.fourSumCount01(nums1, nums2, nums3, nums4));
    }
}