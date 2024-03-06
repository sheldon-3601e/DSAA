package com.sheldon.basic.backTracking_;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class combinationSum2_ {

    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    boolean[] used;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        int sum = 0;
        // 记录当前值是否被使用
        used = new boolean[candidates.length];
        Arrays.fill(used, false);
        // 目标数组排序
        Arrays.sort(candidates);
        backtracking(candidates, target, sum, 0, used);
        return result;
    }

    void backtracking(int[] candidates, int target, int sum, int startIndex, boolean[] used) {

        if (sum == target) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = startIndex; i < candidates.length  && sum + candidates[i] <= target; i++) {
            if((i > 0 && candidates[i - 1] == candidates[i] && used[i - 1]) == true){
                continue;
            }
            used[i ] = true;
            sum += candidates[i];
            path.add(candidates[i]);
            backtracking(candidates, target, sum, i + 1, used);
            used[i ] = false;
            path.removeLast();
            sum -= candidates[i];
        }
    }

    public static void main(String[] args) {
        combinationSum2_ solution = new combinationSum2_();
        int[] candidates = {10,1,2,7,6,1,5};
        List<List<Integer>> result = solution.combinationSum2(candidates, 8);
        System.out.println(result);
    }
}