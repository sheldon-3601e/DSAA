package com.sheldon.HotTopic;

/**
 * 238. 除自身以外数组的乘积
 * 给你一个长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，
 * 其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
 * 链接：https://leetcode-cn.com/problems/product-of-array-except-self/
 */
class productExceptSelf_16 {
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] pre = new int[length];
        pre[0] = 1;
        int[] suf = new int[length];
        int temp = 1;
        for (int i = 1; i < length; i++) {
            temp *= nums[i - 1];
            pre[i] = temp;
        }
        suf[length - 1] = 1;
        temp = 1;
        for (int i = length - 2; i >= 0; i--) {
            temp *= nums[i + 1];
            suf[i] = temp;
        }
        int[] result = new int[length];
        for (int i = 0; i < length; i++) {
            result[i] = pre[i] * suf[i];
        }
        return result;
    }

    public static void main(String[] args) {
        productExceptSelf_16 productExceptSelf = new productExceptSelf_16();
        int[] nums = {1, 2, 3, 4};
        int[] result = productExceptSelf.productExceptSelf(nums);
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}