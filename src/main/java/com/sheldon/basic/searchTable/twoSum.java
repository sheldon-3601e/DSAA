package com.sheldon.basic.searchTable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * <p>
 * 你可以按任意顺序返回答案。
 * <p>
 *  
 * <p>
 * 链接：https://leetcode.cn/leetbook/read/all-about-lockup-table/fjq7e/
 */

public class twoSum {

    /**
     * 方法二：哈希表
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum02(int[] nums, int target) {
        int[] res = new int[2];
        // 哈希表 -> key:元素值，value:元素下标
        Map map = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            // 查询表中是否有对应的元素
            int temp = target - nums[i];
            // 如果有，就返回结果
            if (map.containsKey(temp)) {
                res[0] = (int) map.get(temp);
                res[1] = i;
                return res;
            }
            // 如果没有，就添加到哈希表中
            map.put(nums[i], i);
        }
        return res;
    }

    /**
     * 暴力解法
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum01(int[] nums, int target) {
        int[] res = new int[2];
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    res[0] = i;
                    res[1] = j;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        twoSum twoSum = new twoSum();
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] res = twoSum.twoSum02(nums, target);
        for (int item : res) {
            System.out.println(item);
        }
    }
}