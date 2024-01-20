package com.sheldon.Arrays;

import java.util.Arrays;

/**
 * @ClassName Code06
 * @Author 26483
 * @Date 2024/1/18 9:34
 * @Version 1.0
 * @Description 给你一个大小为 m x n 的矩阵 mat ，请以对角线遍历的顺序，用一个数组返回这个矩阵中的所有元素。
 * 输入：mat = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,4,7,5,3,6,8,9]
 */
public class Code06 {

    public static int[] findDiagonalOrder(int[][] mat) {
        // 如果输入数组为空，则返回空数组
        if (mat == null || mat.length == 0) {
            return new int[0];
        }
        // 获取数组的行数和列数
        int n = mat.length;
        int m = mat[0].length;
        // 定义一个数组，保存遍历的结果
        // m * n -> 对角线的个数
        int[] result = new int[n * m];

        // 当对角线为偶数时，方向是右上角到左下角
        // 当对角线为奇数时，方向是左下角到右上角
        for (int i = 0, idx = 0; i < n + m - 1; i++) {
            // 当对角线为偶数
            if (i % 2 == 0) {
                // 1. 判断起始位置（对角线上，元素的横纵坐标之和为对角线的值）
                // 2. 当对角线 i < n - 1 时，起始位置为 (i, 0)
                // 3. 当对角线 i >= n - 1 时，起始位置为 (n - 1, i - n + 1)
                for (int x = Math.min(i, n - 1); x >= Math.max(0, i - m + 1); x--) {
                    result[idx++] = mat[x][i - x];
                }
            } else {
                for (int x = Math.max(0, i - m + 1); x <= Math.min(i, n - 1); x++) {
                    result[idx++] = mat[x][i - x];
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] diagonalOrder = findDiagonalOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
        System.out.println(Arrays.toString(diagonalOrder));
    }

}
