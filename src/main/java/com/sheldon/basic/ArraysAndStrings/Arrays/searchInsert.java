package com.sheldon.basic.ArraysAndStrings.Arrays;

/**
 * @ClassName code02
 * @Author 26483
 * @Date 2024/1/17 10:43
 * @Version 1.0
 *  
 */
public class searchInsert {
    /**
     * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
     * <p>
     * 请必须使用时间复杂度为 O(log n) 的算法。
     * <p>
     *  
     * <p>
     * 示例 1:
     * <p>
     * 输入: nums = [1,3,5,6], target = 5
     * 输出: 2
     *
     *
     *
     * @param nums
     * @param target
     * @return
     */
    public static int searchInsert01(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (target <= nums[i]) {
                return i;
            }
        }
        return nums.length;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,5,6};
        int i = searchInsert01(nums, 5);
        System.out.println(i);
    }
}
