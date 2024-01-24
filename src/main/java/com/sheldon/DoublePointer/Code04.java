package com.sheldon.DoublePointer;

import java.util.Arrays;

/**
 * @ClassName Code04
 * @Author 26483
 * @Date 2024/1/24 8:46
 * @Version 1.0
 * @Description TODO
 */
public class Code04 {

    /**
     * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
     *
     * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
     *
     * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
     *
     * @param nums
     * @param val
     * @return
     */

    public static int removeElement(int[] nums, int val) {

        int slow = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[slow] = nums[i];
                slow++;
            }
        }

        return slow;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 2, 2, 2, 2, 2, 2};
        int val = 2;
        int test = removeElement(nums, val);
        System.out.println(Arrays.toString(nums));
    }

}
