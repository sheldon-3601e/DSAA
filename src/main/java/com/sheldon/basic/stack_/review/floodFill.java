package com.sheldon.basic.stack_.review;

/**
 *
 * 有一幅以 m x n 的二维整数数组表示的图画 image ，其中 image[i][j] 表示该图画的像素值大小。
 *
 * 你也被给予三个整数 sr ,  sc 和 newColor 。你应该从像素 image[sr][sc] 开始对图像进行 上色填充 。
 *
 * 为了完成 上色工作 ，从初始像素开始，记录初始坐标的 上下左右四个方向上 像素值与初始坐标相同的相连像素点，接着再记录这四个方向上符合条件的像素点与他们对应 四个方向上 像素值与初始坐标相同的相连像素点，……，重复该过程。将所有有记录的像素点的颜色值改为 newColor 。
 *
 * 最后返回 经过上色渲染后的图像 。
 *
 * 链接：https://leetcode.cn/leetbook/read/queue-stack/g02cj/
 *
 * 思路：深度优先搜索，与岛屿问题类似
 */
public class floodFill {
    public int[][] floodFill01(int[][] image, int sr, int sc, int color) {
        int target = image[sr][sc];
        if (target == color) {
            return image;
        }
        dfs(image, sr, sc, color, target);
        return image;
    }
    

    public static void dfs(int[][] image, int sr, int sc, int color, int target) {
        if (sr < 0 || sc < 0 || sr >= image.length || sc >= image[sr].length || image[sr][sc] != target) {
            return;
        }
        image[sr][sc] = color;
        dfs(image, sr - 1, sc, color, target);
        dfs(image, sr + 1, sc, color, target);
        dfs(image, sr, sc - 1, color, target);
        dfs(image, sr, sc + 1, color, target);
    }

    public static void main(String[] args) {
        floodFill ff = new floodFill();
        int[][] image = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        int sr = 1;
        int sc = 1;
        int newColor = 2;
        int[][] result = ff.floodFill01(image, sr, sc, newColor);
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
}