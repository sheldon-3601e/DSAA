package com.sheldon.basic;

import java.util.LinkedList;

class numIslands_BFS {

    static class Point{
        int x;
        int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int numIslands(char[][] grid) {
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1' &&!visited[i][j]) {
                    bfs(grid, new Point(i, j), visited, directions);
                    count++;
                }
            }
        }
        return count;
    }

    public static void bfs(char[][] grid, Point point, boolean[][] visited, int[][] directions) {
        LinkedList<Point> queue = new LinkedList<>();
        queue.offer(point);
        visited[point.x][point.y] = true;
        while (!queue.isEmpty()) {
            Point current = queue.poll();
            for (int[] direction : directions) {
                int newX = current.x + direction[0];
                int newY = current.y + direction[1];
                if (newX >= 0 && newX < grid.length && newY >= 0 && newY < grid[0].length
                        && grid[newX][newY] == '1' &&!visited[newX][newY]) {
                    grid[newX][newY] = '0';
                    queue.offer(new Point(newX, newY));
                    visited[newX][newY] = true;
                }
            }
        }
    }
}