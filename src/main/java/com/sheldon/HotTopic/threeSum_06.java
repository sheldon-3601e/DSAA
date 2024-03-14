package com.sheldon.HotTopic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15. 三数之和
 * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请
 *
 * 你返回所有和为 0 且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 * 链接：https://leetcode.cn/problems/3sum/description/?envType=study-plan-v2&envId=top-100-liked
 *
 */
class threeSum_06 {
    public List<List<Integer>> threeSum(int[] nums) {
        // 将三数之和，转化为求两数之和
        // 要点是，不管是三数，还是两数，都要注意去重
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            // 跳过重复的元素
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int target = -nums[i];
            List<List<Integer>> twoSum = TwoSum(nums, target, i + 1);
            for (List<Integer> list : twoSum) {
                result.add(Arrays.asList(nums[i], list.get(0), list.get(1)));
            }
        }
        return result;
    }

    /**
     * 寻找两数之和
     * 结果不一定唯一
     *
     * @param nums
     * @param target
     * @param start
     * @return
     */
    private List<List<Integer>> TwoSum(int[] nums, int target, int start) {
        List<List<Integer>> result = new ArrayList<>();
        int left = start;
        int right = nums.length - 1;
        while (left < right) {
            int leftValue = nums[left];
            int rightValue = nums[right];
            int sum = leftValue + rightValue;
            if (sum == target) {
                result.add(Arrays.asList(leftValue, rightValue));

                // 跳过重复的元素
                while (left < right && leftValue == nums[left + 1]) {
                    left++;
                }
                while (left < right && rightValue == nums[right - 1]) {
                    right--;
                }
                left++;
                right--;
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        threeSum_06 threeSum06 = new threeSum_06();
        int[] nums = {0, 0, 0};
        List<List<Integer>> result = threeSum06.threeSum(nums);
        System.out.println(result);
    }
}