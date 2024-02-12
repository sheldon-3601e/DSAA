package com.sheldon.basic.searchTable.map_;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给你两个整数数组 nums1 和 nums2 ，请你以数组形式返回两数组的交集。返回结果中每个元素出现的次数，应与元素在两个数组中都出现的次数一致（如果出现次数不一致，则考虑取较小值）。可以不考虑输出结果的顺序。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2,2]
 * <p>
 * 链接：https://leetcode.cn/leetbook/read/all-about-lockup-table/fznzm/
 */
public class intersect {
    /**
     * 方法一：哈希表
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersect01(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        List res = new ArrayList();
        // 记录数组1 中数值出现的次数
        for (int iten : nums1 ) {
            map.put(iten, map.getOrDefault(iten, 0) + 1);
        }
        // 遍历数组2，如果map中存在，且次数大于0，就添加到结果集中
        for (int iten : nums2 ) {
            if (map.containsKey(iten) && map.get(iten) > 0) {
                res.add(iten);
                map.put(iten, map.get(iten) - 1);
            }
        }
        int[] resArr = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            resArr[i] = (int) res.get(i);
        }
        return resArr;
    }

    public static void main(String[] args) {
        intersect intersect = new intersect();
        int[] nums2 = {4,9,5};
        int[] nums1 = {9,4,9,8,4};
        int[] res = intersect.intersect01(nums1, nums2);
        for (int iten : res) {
            System.out.println(iten);
        }
    }
}