package com.sheldon.basic.backTracking_;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 77. 组合
 * https://leetcode-cn.com/problems/combinations/
 * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 *
 * 你可以按 任何顺序 返回答案。
 */
class combinationSum3_ {
    // 返回值
    List<List<Integer>> result = new ArrayList<>();
    // 单个结果
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> combine(int n, int k) {
        backtracking(n,k,1);
        return result;
    }

    void backtracking(int n, int k, int startIndex){
        if(path.size() == k) {
            result.add(new ArrayList(path));
            return;
        }
        // 遍历当前节点
        for(int i = startIndex; i <= n; i++) {
            path.add(i);
            backtracking(n, k, i + 1);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        combinationSum3_ solution = new combinationSum3_();
        List<List<Integer>> result = solution.combine(4, 2);
        System.out.println(result);
    }

}