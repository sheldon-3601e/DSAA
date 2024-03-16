package com.sheldon.HotTopic;

/**
 * 42. 接雨水
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算下雨之后能够
 * 捕获的雨水总量。
 * 链接：https://leetcode-cn.com/problems/trapping-rain-water
 */
class trap_07 {
    public int trap(int[] height) {

        int left = 0;
        int right = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;

        int result = 0;

        while (left < right) {
            // 水的多少要看木桶效应，即两侧木板矮的一边
            if (height[left] < height[right]) {
                // 左侧为矮的一边
                // 找到矮的一边后，有三种情况
                // 1. 当前高度大于矮的一边，那此时就不会积水，更新最大值
                // 2. 当前高度等于矮的一边，同上，也不会积水
                // 3. 当前的高度小于矮的一边，那水等于矮的一边的高度减去当前高度
                if (height[left] >= leftMax) {
                    // 1.2 情况
                    // 更新最大值
                    leftMax = height[left];
                } else {
                    // 3 情况
                    // 累加积水值
                    result += leftMax - height[left];
                }
                left++;
            } else {
                // 同理
                if (height[right] >= rightMax) {
                    // 1.2 情况
                    // 更新最大值
                    rightMax = height[right];
                } else {
                    // 3 情况
                    // 累加积水值
                    result += rightMax - height[right];
                }
                right--;
            }
        }
        return result;
    }
}