package com.sheldon.basic.searchTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请
 * <p>
 * 你返回所有和为 0 且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 *  
 * <p>
 * 链接：https://leetcode.cn/leetbook/read/all-about-lockup-table/xhhlwv/
 */
class threeSum {

    /**
     * 方法一：排序 + 双指针
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum01(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); // 先对数组进行排序
        int n = nums.length;

        // 遍历数组
        for (int i = 0; i < n - 2; i++) {
            // 跳过重复元素
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            // 定义左右指针
            int left = i + 1, right = n - 1;
            while (left < right) {
                int total = nums[i] + nums[left] + nums[right];
                // 满足条件
                if (total == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    // 跳过重复元素
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    // 缩小指针范围
                    left++;
                    right--;
                } else if (total < 0) {
                    // 根据总和的大小，移动指针
                    left++;
                } else {
                    right--;
                }
            }
        }
        return result;
    }

    public List<List<Integer>> threeSum02(int[] nums) {
        List<List<Integer>> res = new ArrayList();
        Arrays.sort(nums);
        int n = nums.length;

        for (int i = 0; i < n - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = n - 1;
            while (left < right) {
                int total = nums[i] + nums[left] + nums[right];
                if (total == 0) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;
                } else if (total < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        threeSum threeSum = new threeSum();
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> res = threeSum.threeSum01(nums);
        for (List<Integer> item : res) {
            System.out.println(item);
        }
    }
}