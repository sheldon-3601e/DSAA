package com.sheldon.HotTopic;

/**
 * 283. 移动零
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 *
 * 链接：https://leetcode.cn/problems/move-zeroes/description/?envType=study-plan-v2&envId=top-100-liked
 */
class MoveZeroes_04 {
    public void moveZeroes(int[] nums) {
        if(nums.length == 1) {
            return;
        }
        // 非零元素存放在位置
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            // 如果元素不为零，就移到零的位置
            if (nums[i] != 0) {
                nums[index] = nums[i];
                index++;
            }
        }

        // 将非零之后的元素，全部为零
        for (int i = index + 1; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}