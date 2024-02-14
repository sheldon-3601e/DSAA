package com.sheldon.basic.searchTable;

import java.util.HashMap;
import java.util.Map;

/**\
 *
 * 给你一个整数数组 nums 和一个整数 k ，判断数组中是否存在两个 不同的索引 i 和 j ，满足 nums[i] == nums[j] 且 abs(i - j) <= k 。如果存在，返回 true ；否则，返回 false 。
 * <p>
 * 链接：https://leetcode.cn/leetbook/read/all-about-lockup-table/xhn7c6/
 *
 */

class containsNearbyDuplicate {

    /**
     * 哈希表 + 滑动窗口
     * @param nums
     * @param k
     * @return
     */
    public boolean containsNearbyDuplicate02(int[] nums, int k) {
        int n = nums.length;
        if(n == 0 || k == 0) {
            return false;
        }
        // key: 数组元素, value: 下标
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            if(map.containsKey(nums[i])) {
                if(i - map.get(nums[i]) <= k) {
                    return true;
                }
            }
            map.put(nums[i], i);
        }
        return false;
    }

    /**
     * 暴力解法
     * @param nums
     * @param k
     * @return
     */
    public boolean containsNearbyDuplicate01(int[] nums, int k) {
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j <= i + k; j++) {
                if(j >= n) {
                    continue;
                }
                if(nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        containsNearbyDuplicate solution = new containsNearbyDuplicate();
        int[] nums = {1,2,3,1};
        int k = 3;
        System.out.println(solution.containsNearbyDuplicate01(nums, k));

    }
}