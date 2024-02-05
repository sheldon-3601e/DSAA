package com.sheldon.basic.Queue;

import java.util.LinkedList;

/**
 * @ClassName numIslands
 * @Author 26483
 * @Date 2024/2/4 10:31
 * @Version 1.0
 * @Description BFS
 */
public class numIslands {
    /**
     * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
     * <p>
     * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
     * <p>
     * 此外，你可以假设该网格的四条边均被水包围。
     * <p>
     * 思路：
     * 1.前提：使用广度优先搜索
     * 2.循环遍历二维数组，当遇到岛屿时，岛屿数量加一
     * 3.然后对该点进行广度优先搜索
     * 4.将岛屿及其周边的岛屿都置于水（即置为0）
     * 5.最后返回岛屿数量
     */

    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        System.out.println(getNumsLands(grid));
    }

    public static int getNumsLands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        // 岛屿数量
        int count = 0;
        // 遍历
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    bfs(grid, i, j);
                }
            }
        }
        return count;
    }

    public static void bfs(char[][] grid, int i, int j) {
        LinkedList<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i, j});
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];

            if (x >= 0 && x < grid.length && y >= 0 && y < grid[x].length && grid[x][y] == '1') {
                grid[x][y] = '0';
                queue.add(new int[]{x - 1, y});
                queue.add(new int[]{x + 1, y});
                queue.add(new int[]{x, y - 1});
                queue.add(new int[]{x, y + 1});
            }
        }
    }
}
