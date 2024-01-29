package com.sheldon.basic.ArraysAndStrings.summarisation;

import java.util.LinkedList;

/**
 * @ClassName Code07
 * @Author 26483
 * @Date 2024/1/26 9:01
 * @Version 1.0
 *  
 */
public class Code07 {

    /**
     * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
     *
     * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
     *
     *  
     *
     * 示例 1:
     *
     * 输入: nums = [0,1,0,3,12]
     * 输出: [1,3,12,0,0]
     *
     * @param nums
     */
    // 因为是对数组的操作，不能复制新的组数，所以考虑到使用快慢指针解决
    public void test(int[] nums) {
        // 判断边界条件
        if (nums.length == 1) {
            return;
        }
        // 定义慢指针，指向当前非零的位置
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            // 如果当前元素不为0，就将当前元素赋值给慢指针所指向的位置，然后慢指针向后移动一位
            if (nums[i] != 0) {
                nums[index++] = nums[i];
            }
        }
        // 把慢指针后面的元素全部置为0
        for (; index < nums.length; index++) {
            nums[index] = 0;
        }
    }

    public static void main(String[] args) {
        Code07 code07 = new Code07();
        int[] nums = {1,0};
        code07.test(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }

}
