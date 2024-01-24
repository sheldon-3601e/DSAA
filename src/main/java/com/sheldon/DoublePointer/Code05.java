package com.sheldon.DoublePointer;

/**
 * @ClassName Code05
 * @Author 26483
 * @Date 2024/1/24 8:51
 * @Version 1.0
 * @Description TODO
 */
public class Code05 {

    /**
     * 给定一个二进制数组 nums ， 计算其中最大连续 1 的个数。
     *
     *  
     *
     * 示例 1：
     *
     * 输入：nums = [1,1,0,1,1,1]
     * 输出：3
     * 解释：开头的两位和最后的三位都是连续 1 ，所以最大连续 1 的个数是 3.
     *
     * @param nums
     * @return
     */

    public int findMaxConsecutiveOnes(int[] nums) {
        int temp = 0;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            // 当数组值为 1 时，temp 自增，否则 temp 重置为 0
            if (nums[i] == 1) {
                temp++;
            } else {
                temp = 0;
            }
            // 每次循环都比较 temp 和 max 的大小，将较大值赋值给 max
            max = Math.max(max, temp);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 0, 1, 1, 1};
        Code05 code05 = new Code05();
        int test = code05.findMaxConsecutiveOnes(nums);
        System.out.println(test);
    }

}
