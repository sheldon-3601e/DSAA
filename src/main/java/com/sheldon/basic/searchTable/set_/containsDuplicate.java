package com.sheldon.basic.searchTable.set_;

import java.util.HashSet;
import java.util.Set;

/**
 * 给你一个整数数组 nums 。如果任一值在数组中出现 至少两次 ，返回 true ；如果数组中每个元素互不相同，返回 false 。
 *  
 *<p>
 * 示例 1：
 *<p>
 * 输入：nums = [1,2,3,1]
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,3,4]
 * 输出：false
 * <p>
 * 链接：https://leetcode.cn/leetbook/read/all-about-lockup-table/fkl1h/
 */
class containsDuplicate {
    public boolean containsDuplicate01(int[] nums) {
        Set res = new HashSet();
        for (int item : nums ) {
            if (!res.add(item)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        containsDuplicate containsDuplicate = new containsDuplicate();
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 9};
        System.out.println(containsDuplicate.containsDuplicate01(nums));
    }
}