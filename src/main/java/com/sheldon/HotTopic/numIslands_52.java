package com.sheldon.HotTopic;

/**
 * Created by sheldon on 18-7-26.
 * 52. N-Queens II
 * Question: Follow up for N-Queens problem.
 *
 */

class numIslands_52 {
    public int numIslands(char[][] grid) {

        int res = 0;

        boolean[][] isVisited = new boolean[grid.length][grid[0].length];
        int[][] direction = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1' && !isVisited[i][j]) {
                    res++;
                    traversal(grid, i, j, direction, isVisited);
                }
            }
        }

        return res;
    }

    public static void traversal(char[][] grid, int i, int j, int[][] direction, boolean[][] isVisited) {

        grid[i][j] = '0';
        isVisited[i][j] = true;

        for (int k = 0; k < direction.length; k++) {
            int x = i + direction[k][0];
            int y = j + direction[k][1];
            if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == '1' && !isVisited[x][y]) {
                traversal(grid, x, y, direction, isVisited);
            }
        }
    }
}