package com.sheldon.basic.searchTable;

import java.util.HashMap;
import java.util.Map;

class maxPoints {
    public int maxPoints01(int[][] points) {
        int result = 0;
        if (points.length < 3) {
            return points.length;
        }

        for (int i = 0; i < points.length ; i++ ) {
            // 记录点 i 到所有其他点的斜率
            // key - 斜率，value - 斜率相同的点
            Map<Double, Integer> map = new HashMap<>();
            
            for (int j = 0; j < points.length ; j++ ) {
                if (i != j) {
                    // 记录点 i 到点 j 的斜率
                    double temp = calculateSlope(points[i], points[j]);
                    map.put(temp, map.getOrDefault(temp, 1) + 1);
                }
            }

            result = Math.max(result, map.values().stream().max(Integer::compareTo).orElse(0));
        }
        return result;
    }

    public static double calculateSlope(int[] x, int[] y) {
        if (x[0] == y[0]) {
            // 如果横坐标相等，斜率无穷大，返回 Double.POSITIVE_INFINITY
            return Double.POSITIVE_INFINITY;
        }
        return (double) (y[1] - x[1]) / (y[0] - x[0]);
    }

    public static void main(String[] args) {
        maxPoints maxPoints = new maxPoints();
        int[][] points = {{0,0}};
        System.out.println(maxPoints.maxPoints01(points));
    }

}