package com.sheldon.basic.avarice;

class maxSubArray_ {
    public int maxSubArray(int[] nums) {
        // 记录最终的结果值
        int result = Integer.MIN_VALUE;
        // 记录每次累加的值
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            count += nums[i];
            if (count > result) {
                result = count;
            }
            // 如果 count < 0，那就说明如果继续添加，就会拉低总和
            // 所以重置，重新开始
            if (count < 0) {
                count = 0;
            }
        }
        return result;
    }
}