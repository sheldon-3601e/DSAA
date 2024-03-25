package com.sheldon.HotTopic;

/**
 * 11. 盛最多水的容器
 * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
 *
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 返回容器可以储存的最大水量。
 *
 * 说明：你不能倾斜容器。
 *
 * 链接：https://leetcode-cn.com/problems/container-with-most-water
 */
class MaxArea_05 {
    public int maxArea(int[] height) {
        int res = 0;
        // 定义左右指针
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            int temp = (right - left) * Math.min(height[left], height[right]);
            // 更新最大值
            res = Math.max(res, temp);
            // 根据两边的高度，移动指针
            // 因为底部在减少，所以高度要增加
            // 所以移动高度较小的指针
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return res;
    }
    
}