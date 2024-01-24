package com.sheldon.DoublePointer;

/**
 * @ClassName Code06
 * @Author 26483
 * @Date 2024/1/24 9:07
 * @Version 1.0
 * @Description TODO
 */
public class Code06 {

    /**
     * 给定一个含有 n 个正整数的数组和一个正整数 target 。
     *
     * 找出该数组中满足其总和大于等于 target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
     *
     *  
     *
     * 示例 1：
     *
     * 输入：target = 7, nums = [2,3,1,2,4,3]
     * 输出：2
     * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
     *
     * @param target
     * @param nums
     * @return
     */

    // 暴力循环
    public int minSubArrayLenBF(int target, int[] nums) {

        int temp = 0;
        for (int i = 0; i < nums.length; i++) {
            // 初始化 sum 为 0
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                // 当 sum 大于等于 target
                // 判断 temp 是否为 0，如果为 0，将 j - i + 1 赋值给 temp
                // 如果 temp 不为 0，将 temp 和 j - i + 1 比较，将较小值赋值给 temp
                if (sum >= target) {
                    temp = temp == 0 ? j - i + 1 : Math.min(temp, j - i + 1);
                    break;
                }
            }
        }
        return temp;
    }

    // 滑动窗口
    public int minSubArrayLenSW(int target, int[] nums) {

        // 初始化左窗口——慢指针
        int left = 0;
        int min = Integer.MAX_VALUE;
        int sum = 0;

        // 循环右窗口——快指针
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];

            // 当 sum 大于等于 target 时，循环左窗口，即不断缩小范围
            while (sum >= target) {
                min = Math.min(min, right - left + 1);
                sum -= nums[left];
                left++;
            }
        }
        // 如果 min 为 Integer.MAX_VALUE，说明没有符合条件的子数组，返回 0
        return min == Integer.MAX_VALUE ? 0 : min;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,1,2,4,3};
        int target = 7;
        Code06 code06 = new Code06();
        int test = code06.minSubArrayLenSW(target, nums);
        System.out.println(test);
    }

}
