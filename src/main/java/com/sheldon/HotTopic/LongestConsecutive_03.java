package com.sheldon.HotTopic;

import java.util.HashSet;
import java.util.Set;

/**
 * 128. 最长连续序列
 * 链接：https://leetcode-cn.com/problems/longest-consecutive-sequence/
 */
class LongestConsecutive_03 {
    public int longestConsecutive(int[] nums) {
        int res = 0;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        for (int num : set){
            // 当它的前一个数不在数组中，说明它是一个连续序列的第一个数
            if (!set.contains(num - 1)) {
                int curNum = num;
                int curLen = 1;
                // 开始向后遍历
                while (set.contains(curNum + 1)) {
                    curNum++;
                    curLen++;
                }
                // 更新结果
                res = Math.max(res, curLen);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};
        LongestConsecutive_03 longestConsecutive03 = new LongestConsecutive_03();
        int res = longestConsecutive03.longestConsecutive(nums);
        System.out.println(res);
    }
}