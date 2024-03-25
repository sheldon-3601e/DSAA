package com.sheldon.HotTopic;

import java.util.ArrayList;
import java.util.List;

/**
 * 54. 螺旋矩阵
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 * https://leetcode-cn.com/problems/spiral-matrix/
 */
class SpiralOrder_19 {
    public List<Integer> spiralOrder(int[][] matrix) {
        // 定义一个相同的数组，用于标记是否已经访问过
        // boolean类型，默认为 false
        int rowLength = matrix.length;
        int colLength = matrix[0].length;
        List<Integer> result = new ArrayList<>();
        boolean[][] isVisited = new boolean[rowLength][colLength];
        int[][] dirs = {{0,1},{1, 0}, {0,-1},{-1,0}};
        // 转变方向，有四种可能
        int row = 0;
        int col = 0;
        // 操控方向
        int dir = 0;
        while (result.size() < rowLength * colLength) {
            result.add(matrix[row][col]);
            isVisited[row][col] = true;

            // 获取下一个位置
            int nextRow = row + dirs[dir][0];
            int nextCol = col + dirs[dir][1];

            // 判断下一个位置是否合法
            if (nextRow < 0 || nextRow >= rowLength || nextCol < 0 || nextCol >= colLength || isVisited[nextRow][nextCol]) {
                // 说明位置不合法，需要转变方向
                dir = (dir + 1) % 4;
                nextRow = row + dirs[dir][0];
                nextCol = col + dirs[dir][1];
            }
            // 更新位置信息
            row = nextRow;
            col = nextCol;
        }
        return result;
    }

    public static void main(String[] args) {
        SpiralOrder_19 spiralOrder19 = new SpiralOrder_19();
        int[][] matrix = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        List<Integer> result = spiralOrder19.spiralOrder(matrix);
        System.out.println(result);
    }
}