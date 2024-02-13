package com.sheldon.basic.searchTable;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定平面上 n 对 互不相同 的点 points ，其中 points[i] = [xi, yi] 。回旋镖 是由点 (i, j, k) 表示的元组 ，其中 i 和 j 之间的欧式距离和 i 和 k 之间的欧式距离相等（需要考虑元组的顺序）。
 * <p>
 * 返回平面上所有回旋镖的数量。
 * <p>
 * 示例 1：
 * <p>
 * 输入：points = [[0,0],[1,0],[2,0]]
 * 输出：2
 * 解释：两个回旋镖为 [[1,0],[0,0],[2,0]] 和 [[1,0],[2,0],[0,0]]
 * <p>
 * 链接：https://leetcode.cn/leetbook/read/all-about-lockup-table/xhp45m/
 *
 */

class numberOfBoomerangs {
    public int numberOfBoomerangs01(int[][] points) {
        int result = 0;

        for (int i = 0; i < points.length ; i++ ) {
            // 记录点 i 到所有其他点的距离
            // key - 距离，value - 该距离出现的次数
            Map<Integer, Integer> map = new HashMap<>();
            
            for (int j = 0; j < points.length ; j++ ) {
                if (i != j) {
                    // 记录点 i 到点 j 的距离
                    int temp = distance(points[i], points[j]);
                    map.put(temp, map.getOrDefault(temp, 0) + 1);
                }
            }

            // 对于每个点 i，遍历哈希表中的每个距离，计算回旋镖的数量
            for (int count : map.values()) {
                // 通过该距离对应的点的个数，计算取出两个点的排列顺序
                result += count * (count - 1);
            }
        }
        return result;
    }

    public static int distance(int[] x, int[] y) {
        return (int) (Math.pow(x[0] - y[0], 2) + Math.pow(x[1] - y[1], 2));
    }

    public static void main(String[] args) {
        numberOfBoomerangs numberOfBoomerangs = new numberOfBoomerangs();
        int[][] points = {{0, 0}, {1, 0}, {2, 0}};
        System.out.println(numberOfBoomerangs.numberOfBoomerangs01(points));
    }
}