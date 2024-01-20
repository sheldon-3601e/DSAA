package com.sheldon.Arrays;

/**
 * @ClassName code04
 * @Author 26483
 * @Date 2024/1/18 8:18
 * @Version 1.0
 * @Description TODO
 */
public class Code04 {

    /**
     * 给你一幅由 N × N 矩阵表示的图像，其中每个像素的大小为 4 字节。请你设计一种算法，将图像旋转 90 度。
     *
     * 不占用额外内存空间能否做到？
     *
     * 示例 1:
     *
     * 给定 matrix =
     * [
     *   [1,2,3],
     *   [4,5,6],
     *   [7,8,9]
     * ],
     *
     * 原地旋转输入矩阵，使其变为:
     * [
     *   [7,4,1],
     *   [8,5,2],
     *   [9,6,3]
     * ]
     *
     * @param matrix
     * @return 如果是顺时针旋转，先对角线翻转，再左右翻转
     * 如果是逆时针旋转，先左右翻转，再对角线翻转
     */
    public void rotate(int[][] matrix) {
        // 先对角线翻转
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix[i].length ; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] =temp;
            }
        }
        // 再左右翻转
        int index = matrix.length >> 1;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < index; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length - j -1];
                matrix[i][matrix.length - j -1] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
        System.out.println("--------------------");
        Code04 code04 = new Code04();
        code04.rotate(matrix);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }

}
