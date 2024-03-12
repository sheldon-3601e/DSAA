package com.sheldon.basic.avarice;

/**
 * 376. 摆动序列
 * 如果连续数字之间的差严格地在正数和负数之间交替，则数字序列称为摆动序列。
 * 第一个差（如果存在的话）可能是正数或负数。少于两个元素的序列也是摆动序列。
 * 例如， [1,7,4,9,2,5] 是一个摆动序列，因为差值 (6,-3,5,-7,3) 是正负交替出现的。
 *
 * 链接：https://leetcode-cn.com/problems/wiggle-subsequence

 */
class wiggleMaxLength_ {
    public int wiggleMaxLength(int[] nums) {
        if(nums.length < 1) {
            return nums.length;
        }

        // 默认最右边有一个节点
        int res = 1;
        // 当前的差值
        int curDiff = 0;
        // 前一个差值
        int preDiff = 0;
        for(int i = 0; i < nums.length - 1; i++) {
            curDiff = nums[i + 1] - nums[i];
            if(preDiff <= 0 && curDiff > 0 || preDiff >= 0 && curDiff < 0) {
                res++;
                preDiff = curDiff;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,2,2,3,4};
        wiggleMaxLength_ wiggleMaxLength = new wiggleMaxLength_();
        System.out.println(wiggleMaxLength.wiggleMaxLength(nums));
    }
}