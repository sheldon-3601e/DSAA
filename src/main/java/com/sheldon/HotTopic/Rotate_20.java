package com.sheldon.HotTopic;

/**
 * 48. 旋转图像
 * 给定一个 n × n 的二维矩阵表示一个图像。
 * 将图像顺时针旋转 90 度。
 * https://leetcode-cn.com/problems/rotate-image/
 */
class Rotate_20 {
    public void rotate(int[][] matrix) {
        int rowLength = matrix.length;
        int colLength = matrix[0].length;
        // 先进行对角线翻转
        for (int row = 0; row < rowLength; row++) {
            for (int col = row + 1; col < colLength; col++) {
                int temp = matrix[row][col];
                matrix[row][col] = matrix[col][row];
                matrix[col][row] = temp;
            }
        }
        // 再进行水平翻转
        for (int row = 0; row < rowLength; row++) {
            for (int col = 0; col < colLength % 2; col++) {
                int temp = matrix[row][col];
                matrix[row][col] = matrix[row][colLength - 1 - col];
                matrix[row][colLength - 1 - col] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        Rotate_20 rotate20 = new Rotate_20();
        rotate20.rotate(matrix);
    }
}