package com.sheldon.basic.stack_.review;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个由 0 和 1 组成的矩阵 mat ，请输出一个大小相同的矩阵，其中每一个格子是 mat 中对应位置元素到最近的 0 的距离。
 *
 * 两个相邻元素间的距离为 1 。
 *
 *  
 *
 * 示例 1：
 *
 *
 *
 * 输入：mat = [[0,0,0],[0,1,0],[0,0,0]]
 * 输出：[[0,0,0],[0,1,0],[0,0,0]]
 *
 * 链接：https://leetcode.cn/leetbook/read/queue-stack/g7pyt/
 */
public class UpdateMatrix {

    /**
     * 思路：从每个 0 开始，使用BFS搜索，将距离更新到新的矩阵中
     * @param mat 输入矩阵
     * @return 距离矩阵
     */

    public static int[][] updateMatrix02(int[][] mat) {
        int[][] newRes = new int[mat.length][mat[0].length];
        boolean[][] visited = new boolean[mat.length][mat[0].length];
        ArrayDeque<int[]> queue = new ArrayDeque<>();

        // 将所有初始为0的位置加入队列，并标记为已访问
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }

        // 设置偏移量，用于BFS搜索
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        // BFS搜索
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int x = curr[0];
            int y = curr[1];
            for (int[] dir : directions) {
                int newX = x + dir[0];
                int newY = y + dir[1];
                // 检查新位置是否合法且未被访问
                if (newX >= 0 && newX < mat.length && newY >= 0 && newY < mat[0].length && !visited[newX][newY]) {
                    // 更新新位置的距离，并加入队列
                    newRes[newX][newY] = newRes[x][y] + 1;
                    visited[newX][newY] = true;
                    queue.offer(new int[]{newX, newY});
                }
            }
        }
        return newRes;
    }

    public static int[][] updateMatrix01(int[][] mat) {
        int[][] newRes = new int[mat.length][mat[0].length];
        Set<String> visited = new HashSet<>();
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 1) {
                    newRes[i][j] = bfs(mat, i, j, visited);
                }
            }
        }
        return newRes;
    }

    public static int bfs(int[][] mat, int x, int y, Set<String> visited) {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{x, y});
        visited.add(x + "-" + y);
        int step = 0;
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while (!queue.isEmpty()) {
            step++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] pos = queue.poll();
                for (int[] dir : directions) {
                    int newX = pos[0] + dir[0];
                    int newY = pos[1] + dir[1];
                    if (newX >= 0 && newX < mat.length && newY >= 0 && newY < mat[0].length) {
                        if (mat[newX][newY] == 0 && !visited.contains(newX + "-" + newY)) {
                            return step;
                        }
                        queue.offer(new int[]{newX, newY});
                        visited.add(newX + "-" + newY);
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] mat = new int[][]{{0, 0, 0}, {0, 1, 0}, {1, 1, 1}};
        int[][] res = updateMatrix02(mat);
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[i].length; j++) {
                System.out.println(res[i][j]);
            }
        }
    }
}
