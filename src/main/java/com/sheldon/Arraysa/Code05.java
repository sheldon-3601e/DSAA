package com.sheldon.Arraysa;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @ClassName Code5
 * @Author 26483
 * @Date 2024/1/18 8:50
 * @Version 1.0
 * @Description 编写一种算法，若M × N矩阵中某个元素为0，则将其所在的行与列清零。
 *
 * @Example 示例 1：
 *
 * 输入：
 * [
 *   [1,1,1],
 *   [1,0,1],
 *   [1,1,1]
 * ]
 * 输出：
 * [
 *   [1,0,1],
 *   [0,0,0],
 *   [1,0,1]
 * ]
 *
 */
public class Code05 {

    public static void setZeroes(int[][] matrix) {
        ArrayList<Integer> x = new ArrayList<>();
        ArrayList<Integer> y = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if ((matrix[i][j] == 0)) {
                    x.add(i);
                    y.add(j);
                }
            }
        }
        x.forEach(i -> {
            Arrays.fill(matrix[i], 0);
        });
        y.forEach(i -> {
            for (int j = 0; j < matrix.length; j++) {
                matrix[j][i] = 0;
            }
        });
    }

    public static void setZeroes02(int[][] matrix) {
        ArrayList<Integer> x = new ArrayList<>();
        ArrayList<Integer> y = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if ((matrix[i][j] == 0)) {
                    x.add(i);
                    y.add(j);
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (x.contains(i) || y.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }

    }

    public static void main(String[] args) {
        int[][] ints = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        System.out.println(Arrays.deepToString(ints));
        setZeroes02(ints);
        System.out.println(Arrays.deepToString(ints));
    }

}
