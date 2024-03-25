package com.sheldon.HotTopic;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 239. 滑动窗口最大值
 * 给你一个整数数组 nums，有一个大小为k的滑动窗口从数组的最左侧移动到数组的最右侧。
 * 链接：https://leetcode-cn.com/problems/sliding-window-maximum/
 */
public class MaxSlidingWindow_11 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        // 结果数组
        int[] result = new int[n - k + 1];
        // 双端队列，存储数组下标
        // 头部存储的是当前窗口中的最大值
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < nums.length; i++) {
            // 1. 判断队列中，是否有不在队列中的值
            if (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }
            // 2. 判断队列中，是否有比当前值小的值
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                // 如果有，就将其弹出，保证最大值在头部
                deque.pollLast();
            }
            // 3. 添加当前值
            deque.offerLast(i);
            // 4. 判断当前窗口是否已经形成，如果形成，将最大值添加到结果数组中
            if (i >= k - 1) {
                result[i - k + 1] = nums[deque.peekFirst()];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        MaxSlidingWindow_11 maxSlidingWindow = new MaxSlidingWindow_11();
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        int[] result = maxSlidingWindow.maxSlidingWindow(nums, k);
        for (int num : result) {
            System.out.print(num + " ");
        }
        // Output: [3, 3, 5, 5, 6, 7]
    }
}
