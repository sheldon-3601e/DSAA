package com.sheldon.basic.backTracking_;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 51. N 皇后
 * n 皇后问题是指在 n×n 的棋盘上放置 n 个皇后，
 * 使得它们不能相互攻击。
 * 给你一个整数 n ，返回所有不同的 n 皇后问题的解决方案。
 * 每一种解法包含一个不同的 n 皇后问题的棋盘，
 * 该棋盘上 n 皇后的位置互不相同，并且没有两个皇后处于同一条横行、纵行或斜线上。
 * 链接：https://leetcode-cn.com/problems/n-queens
 */

class solveNQueens_ {
    List<List<String>> res = new LinkedList<>();

    public List<List<String>> solveNQueens(int n) {
        char[][] temp = new char[n][n];
        for (char[] row : temp) {
            Arrays.fill(row, '.');
        }
        backtracking(n, 0, temp);
        return res;
    }

    public List Array2List(char[][] chessboard) {
        List<String> list = new ArrayList<>();

        for (char[] c : chessboard) {
            list.add(String.copyValueOf(c));
        }
        return list;
    }

    void backtracking(int n, int row, char[][] temp) {
        // 说明找到了正确的解
        if (row == n) {
            res.add(Array2List(temp));
            return;
        }
        for (int col = 0; col < n; col++) {
            if (isValid(row, col, n, temp)) {
                temp[row][col] = 'Q';
                backtracking(n, row + 1, temp);
                temp[row][col] = '.';
            }
        }

    }

    public boolean isValid(int row, int col, int n, char[][] chessboard) {
        // 检查列
        for (int i = 0; i < row; ++i) { // 相当于剪枝
            if (chessboard[i][col] == 'Q') {
                return false;
            }
        }

        // 检查45度对角线
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (chessboard[i][j] == 'Q') {
                return false;
            }
        }

        // 检查135度对角线
        for (int i = row - 1, j = col + 1; i >= 0 && j <= n - 1; i--, j++) {
            if (chessboard[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        solveNQueens_ solveNQueens_ = new solveNQueens_();
        solveNQueens_.solveNQueens(4);

    }
}

