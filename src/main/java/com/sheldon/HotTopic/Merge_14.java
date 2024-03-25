package com.sheldon.HotTopic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 56. 合并区间
 * 给出一个区间的集合，请合并所有重叠的区间。
 * 链接：https://leetcode-cn.com/problems/merge-intervals/
 */
class Merge_14 {
    public static int[][] merge(int[][] intervals) {
        // 先排序
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        if (intervals.length == 1) {
            return intervals;
        }
        List<int[]> list = new ArrayList<>();
        int index = 0;
        // 如果在，再判断结束值是否在区间中，
        for (int i = 0; i < intervals.length; i++) {
            // 先将第一个值加入
            if (i == 0) {
                list.add(intervals[i]);
                continue;
            }
            // 判断第一个值是否在前一个区间中
            int[] cur = intervals[i];
            int[] pre = list.get(index);
            if (cur[0] <= pre[1]) {
                // 如果满足，则判断结束值是否在区间中
                cur[1] = Math.max(cur[1], pre[1]);
            } else {
                // 如果不满足，则将当前区间加入
                list.add(cur);
                index++;
            }
        }
        int[][] result = new int[list.size()][];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] result = merge(intervals);
        for (int[] ints : result) {
            System.out.println(Arrays.toString(ints));
        }
    }
}