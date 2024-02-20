package com.sheldon.basic.ArraysAndStrings.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName Code06
 * @Author 26483
 * @Date 2024/1/18 9:34
 * @Version 1.0
 * @Description 给你一个大小为 m x n 的矩阵 mat ，请以对角线遍历的顺序，用一个数组返回这个矩阵中的所有元素。
 * 输入：mat = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,4,7,5,3,6,8,9]
 */
public class findDiagonalOrder {

    public static int[] findDiagonalOrder02(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int num = m + n - 1;
        int[] res = new int[m * n];
        for (int i = 0, idx = 0; i < num; i++) {
            // 根据奇偶数来判断遍历方向
            int row = 0;
            int col = 0;
            if (i % 2 == 0) {
                // 偶数时，是向右上方遍历
                // 根据对角线的位置，判断起点坐标
                // 当遍历的对角线 i < m 时，起点坐标为 (i, 0)
                // 当遍历的对角线 i >= m 时，起点坐标为 (m - 1, i - (m - 1))
                row = (i < m) ? i : m - 1;
                col = (i < m) ? 0 : i - (m - 1);
                // 遍历当前的对角线
                while (row >= 0 && col >= 0 && row < m && col < n) {
                    res[idx++] = (mat[row][col]);
                    row--;
                    col++;
                }
            } else {
                // 奇数时，向左上方遍历
                // 根据对角线的位置，判断起点坐标
                col = (i < n) ? i : n - 1;
                row = (i < n) ? 0 : i - (n - 1);
                // 遍历当前的对角线
                while (row >= 0 && col >= 0 && row < m && col < n) {
                    res[idx++] = (mat[row][col]);
                    row++;
                    col--;
                }
            }
        }
        return res;
    }

    public static int[] findDiagonalOrder01(int[][] mat) {
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
        int[] diagonalOrder = findDiagonalOrder02(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
        System.out.println(Arrays.toString(diagonalOrder));
    }

}
