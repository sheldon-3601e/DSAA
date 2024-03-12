package com.sheldon.basic.avarice;

/**
 * 55. 跳跃游戏
 * 给你一个非负整数数组 nums ，你最初位于数组的 第一个下标 。数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 判断你是否能够到达最后一个下标，如果可以，返回 true ；否则，返回 false 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [2,3,1,1,4]
 * 输出：true
 * 解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
 *
 * 链接: https://leetcode-cn.com/problems/jump-game
 */
class Solution {

    // 本题的是否到达，可以转化为节点的跳跃范围是否覆盖了最后一个节点
    public boolean canJump(int[] nums) {
        // 跳跃覆盖的范围
        int cover = 0;
        int size = nums.length;
        for (int i = 0; i <= cover; i++) {
            // 更新最远覆盖范围
            // 当前节点和他能跳跃的距离的和
            cover = Math.max(cover, i + nums[i]);
            if (cover >= size - 1) {
                return true;
            }
        }
        return false;
    }
}