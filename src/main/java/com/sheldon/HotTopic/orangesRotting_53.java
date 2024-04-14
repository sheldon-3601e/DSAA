package com.sheldon.HotTopic;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author sheldon
 * @date 2020/11/25
 * 994. Rotting Oranges
 * https://leetcode-cn.com/problems/rotting-oranges/
 */

class orangesRotting_53 {

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int orangesRotting(int[][] grid) {

        Queue<Point> queue = new LinkedList<>();
        int row = grid.length;
        int col = grid[0].length;
        boolean[][] isVisited = new boolean[row][col];
        int[][] direction = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        int count = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 2 && !isVisited[i][j]) {
                    queue.offer(new Point(i, j));
                }
                if (grid[i][j] == 1) {
                    count++;
                }
            }
        }

        int index = 0;
        while (count > 0 &&!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Point point = queue.poll();
                int x = point.x;
                int y = point.y;
                for (int j = 0; j < direction.length; j++) {
                    int newX = x + direction[j][0];
                    int newY = y + direction[j][1];
                    if (newX >= 0 && newX < row && newY >= 0 && newY < col
                            && !isVisited[newX][newY] && grid[newX][newY] == 1){
                        grid[newX][newY] = 2;
                        isVisited[newX][newY] = true;
                        queue.offer(new Point(newX, newY));
                        count--;
                    }
                }
            }
            index++;
        }

        if (count > 0) {
            return -1;
        }

        return index;
    }

}