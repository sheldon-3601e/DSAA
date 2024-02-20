package com.sheldon.basic.ArraysAndStrings.Arrays;

/**
 * @ClassName code04
 * @Author 26483
 * @Date 2024/1/18 8:18
 * @Version 1.0
 */
public class rotate {

    /**
     * 给你一幅由 N × N 矩阵表示的图像，其中每个像素的大小为 4 字节。请你设计一种算法，将图像旋转 90 度。
     * <p>
     * 不占用额外内存空间能否做到？
     * <p>
     * 示例 1:
     * <p>
     * 给定 matrix =
     * [
     * <p>
     * [1,2,3],
     * <p>
     * [4,5,6],
     * <p>
     * [7,8,9]
     * <p>
     * ],
     * <p>
     * 原地旋转输入矩阵，使其变为:
     * <p>
     * [
     * <p>
     * [7,4,1],
     * <p>
     * [8,5,2],
     * <p>
     * [9,6,3]
     * <p>
     * ]
     *
     * @param matrix
     * @return 如果是顺时针旋转，先对角线翻转，再左右翻转
     * 如果是逆时针旋转，先左右翻转，再对角线翻转
     */
    public void rotate02(int[][] matrix) {
        // 顺时针旋转
        int len = matrix.length;
        int temp = 0;
        // 对角翻折
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        // 水平翻折
        int index = len / 2;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < index; j++) {
                temp = matrix[i][j];
                matrix[i][j] = matrix[i][len - j - 1];
                matrix[i][len - j - 1] = temp;
            }
        }
    }

    public void rotate01(int[][] matrix) {
        // 先对角线翻转
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix[i].length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        // 再左右翻转
        int index = matrix.length >> 1;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < index; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length - j - 1];
                matrix[i][matrix.length - j - 1] = temp;
            }
        }
    }

    public static void main(String[] args) {
        // [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
        int[][] matrix = {{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}};
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
        System.out.println("--------------------");
        rotate rotate = new rotate();
        rotate.rotate02(matrix);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }

}
