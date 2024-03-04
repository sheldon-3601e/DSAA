package com.sheldon.basic.backTracking_;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 216. 组合总和 III
 * 找出所有相加之和为 n 的 k 个数的组合，且满足下列条件：
 *
 * 只使用数字1到9
 * 每个数字 最多使用一次
 * 返回 所有可能的有效组合的列表 。该列表不能包含相同的组合两次，组合可以以任何顺序返回。
 */
class combinationSum3__ {
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        backtracking(k, n, 1, 0);
        return result;
    }

    void backtracking(int num, int targetNum, int startIndex, int sum) {
        if (path.size() == num) {
            if (sum == targetNum) {
                result.add(new ArrayList(path));
            }
            return;

        }

        // 遍历当前节点
        for (int i = startIndex; i <= 9; i++) {
            path.add(i);
            sum += i;
            backtracking(num, targetNum, i + 1, sum);
            path.removeLast();
            sum -= i;
        }
    }

    public static void main(String[] args) {
        combinationSum3__ combinationSum3 = new combinationSum3__();
        List<List<Integer>> result = combinationSum3.combinationSum3(3, 2);
        System.out.println(result);
    }

}