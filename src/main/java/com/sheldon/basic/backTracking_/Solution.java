package com.sheldon.basic.backTracking_;

/**
 * 37. 解数独
 * 编写一个程序，通过已填充的空格来解决数独问题。
 * 数独的解法需 遵循如下规则：
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 * 空白格用 '.' 表示。
 * 链接：https://leetcode-cn.com/problems/sudoku-solver
 */
class Solution {
    public void solveSudoku(char[][] board) {
        backtracking(board);
    }

    boolean backtracking(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                // 排除不用填的格子
                if (board[i][j] != '.') {
                    continue;
                }
                for (char k = '1'; k <= '9'; k++) { // (i, j) 这个位置放k是否合适
                    if (isValid(i, j, k, board)) {
                        board[i][j] = k;
                        if (backtracking(board)) { // 如果找到合适一组立刻返回
                            return true;
                        }
                        board[i][j] = '.';
                    }
                }
                // 循环后，没有找到合适的值
                return false;
            }
        }

        // 走到最后，说明找到了
        return true;
    }

    boolean isValid(int row, int col, int k, char[][] board) {
        // 同行是否重复
        for (int i = 0; i < 9; i++){
            if (board[row][i] == k){
                return false;
            }
        }
        // 同列是否重复
        for (int j = 0; j < 9; j++){
            if (board[j][col] == k){
                return false;
            }
        }
        // 九宫格
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;
        for (int i = startRow; i < startRow + 3; i++) { // 判断9方格里是否重复
            for (int j = startCol; j < startCol + 3; j++) {
                if (board[i][j] == k) {
                    return false;
                }
            }
        }
        return true;
    }
}