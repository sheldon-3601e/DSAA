package com.sheldon.basic.searchTable;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * 给你一个整数数组 nums 和两个整数 indexDiff 和 valueDiff 。
 * <p>
 * 找出满足下述条件的下标对 (i, j)：
 * <p>
 * i != j,
 * abs(i - j) <= indexDiff <br>
 * abs(nums[i] - nums[j]) <= valueDiff <br>
 * 如果存在，返回 true ；否则，返回 false 。 <br>
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3,1], indexDiff = 3, valueDiff = 0
 * 输出：true <br>
 * 解释：可以找出 (i, j) = (0, 3) 。 <br>
 * 满足下述 3 个条件： <br>
 * i != j --> 0 != 3 <br>
 * abs(i - j) <= indexDiff --> abs(0 - 3) <= 3 <br>
 * abs(nums[i] - nums[j]) <= valueDiff --> abs(1 - 1) <= 0 <br>
 * <p>
 * 作者：LeetCode <br>
 * 链接：https://leetcode.cn/leetbook/read/all-about-lockup-table/xhw24c/
 *
 */

class containsNearbyAlmostDuplicate {


    public boolean containsNearbyAlmostDuplicate02(int[] nums, int indexDiff, int valueDiff) {
        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            // 在 set 中查找大于等于 nums[i] - valueDiff 的最小元素
            Long floor = set.floor((long) nums[i] + valueDiff);
            // 如果找到并且差值不超过 valueDiff，则返回 true
            if (floor != null && floor >= (long) nums[i] - valueDiff) {
                return true;
            }
            set.add((long) nums[i]);
            // 维护滑动窗口的大小，确保其不超过 indexDiff
            if (set.size() > indexDiff) {
                set.remove((long) nums[i - indexDiff]);
            }
        }
        return false;
    }

    public boolean containsNearbyAlmostDuplicate01(int[] nums, int indexDiff, int valueDiff) {
        int n = nums.length;
        // key: 数组元素, value: 下标
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            int temp = Math.abs(valueDiff - nums[i]);
            if(map.containsKey(temp)) {
                if(i - map.get(temp) <= indexDiff) {
                    return true;
                }
            }
            map.put(temp, i);
        }
        return false;
    }

    public static void main(String[] args) {
        containsNearbyAlmostDuplicate solution = new containsNearbyAlmostDuplicate();
        int[] nums = {1,5,9,1,5,9};
        int indexDiff = 2;
        int valueDiff = 3;
        System.out.println(solution.containsNearbyAlmostDuplicate02(nums, indexDiff, valueDiff));
    }
}