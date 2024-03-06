package com.sheldon.basic.backTracking_;

import java.util.ArrayList;
import java.util.List;

class Solution {

    List<String> result = new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {
        StringBuilder stringBuilder = new StringBuilder(s);
        backtracking(stringBuilder, 0, 0);
        return result;
    }

    /**
     * 回溯算法
     * @param s 处理的字符串
     * @param startIndex 开始的位置
     * @param pointNum 点的个数
     */
    void backtracking(StringBuilder s, int startIndex, int pointNum) {
        // 终止条件
        // 说明已经找到四个点，只要判断第四段是否合法，如果合法就加入到结果中
        if (pointNum == 3) {
            if (isVisit(s, startIndex, s.length() - 1)) {
                result.add(s.toString());
            }
            return;
        }

        for (int i = startIndex; i < s.length(); i++) {
            // 判断区间内的数字是否合法
            if (isVisit(s, startIndex, i)){
                // 如果合法，就添加一个点
                s.insert(i + 1, '.');
                // 继续找下一个点
                // 点的个数加1
                pointNum++;
                // 因为插入了一个点，所以下一个要从i + 2开始
                backtracking(s, i + 2, pointNum);
                // 回溯
                pointNum--;
                s.deleteCharAt(i + 1);
            } else {
                // 如果不合法，就继续循环
                continue;
            }

        }
    }

    /**
     * 判断区间内的数字是否合法
     * @param s 字符串
     * @param start 开始位置
     * @param end 结束位置
     * @return 是否合法
     */
    boolean isVisit(StringBuilder s, int start, int end) {
        if ( start > end) {
            return false;
        }
        // 1. 不能以0开头
        if (s.charAt(start) == '0' && start != end) {
            return false;
        }
        // 判断是否大于255
        int num = 0;
        for (int i = start; i <= end; i++) {
            num = num * 10 + s.charAt(i) - '0';
            if (num > 255) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> result = solution.restoreIpAddresses("25525511135");
        System.out.println(result);
    }
}