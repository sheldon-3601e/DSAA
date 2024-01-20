package com.sheldon.Arrays;

/**
 * @ClassName code01
 * @Author 26483
 * @Date 2024/1/17 10:32
 * @Version 1.0
 * @Description TODO
 */
public class Code01 {

    /**
     * 给你一个整数数组 nums ，请计算数组的 中心下标 。
     *
     * 数组 中心下标 是数组的一个下标，其左侧所有元素相加的和等于右侧所有元素相加的和。
     *
     * 如果中心下标位于数组最左端，那么左侧数之和视为 0 ，因为在下标的左侧不存在元素。这一点对于中心下标位于数组最右端同样适用。
     *
     * 如果数组有多个中心下标，应该返回 最靠近左边 的那一个。如果数组不存在中心下标，返回 -1 。
     *
     *  
     *
     * 示例 1：
     *
     * 输入：nums = [1, 7, 3, 6, 5, 6]
     * 输出：3
     * 解释：
     * 中心下标是 3 。
     * 左侧数之和 sum = nums[0] + nums[1] + nums[2] = 1 + 7 + 3 = 11 ，
     * 右侧数之和 sum = nums[4] + nums[5] = 5 + 6 = 11 ，二者相等。
     *
     * @param nums
     * @return
     */

        public static int pivotIndex(int[] nums) {
            // 1.先求出数组的总和
            // 2.遍历数组，求出左边的和，右边的和
            // 3.判断左边的和是否等于右边的和
            // 4.如果相等，返回下标，如果不相等，返回-1
            int sum = 0;
            int leftSum = 0;
            for (int num : nums) {
                sum += num;
            }
            for(int i = 0;i < nums.length;i++){
                leftSum +=  nums[i];
                if (leftSum == sum - leftSum + nums[i]) {
                    return i;
                }
            }
            return -1;
        }

    public static void main(String[] args) {
//        int[] nums = {1,7,3,6,5,6};
        int[] nums = {1,2,3};
//        int[] nums = {1,7,3,6,5,6};
        int i = pivotIndex(nums);
        System.out.println(i);
    }
}

