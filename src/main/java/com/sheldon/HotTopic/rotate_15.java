package com.sheldon.HotTopic;

class rotate_15 {
    public void rotate(int[] nums, int k) {

        int[] result = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            result[(i + k) % nums.length] = nums[i];
        }
        System.arraycopy(result, 0, nums, 0, nums.length);
    }
}