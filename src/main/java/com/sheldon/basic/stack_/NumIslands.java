package com.sheldon.basic.stack_;

/**
 * @author sheldon
 */
public class NumIslands {

    public static void main(String[] args) {
    }

    public int numIslands01(char[][] grid) {
        int num = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                // 找到岛屿
                if (grid[i][j] == '1') {
                    num++;
                    // 进行DFS
                    dfs(i, j, grid);
                }
            }
        }
        return num;
    }

    public static void dfs(int i, int j, char[][] grid) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        dfs(i - 1, j, grid); // 上
        dfs(i + 1, j, grid); // 下
        dfs(i, j - 1, grid); // 左
        dfs(i, j + 1, grid); // 右
    }
}