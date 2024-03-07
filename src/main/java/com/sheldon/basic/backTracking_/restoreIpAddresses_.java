package com.sheldon.basic.backTracking_;

import java.util.ArrayList;
import java.util.List;

/**
 * 93. 复原IP地址
 * https://leetcode-cn.com/problems/restore-ip-addresses/
 *
 *有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
 *
 * 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效 IP 地址。
 * 给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能的有效 IP 地址，这些地址可以通过在 s 中插入 '.' 来形成。你 不能 重新排序或删除 s 中的任何数字。你可以按 任何 顺序返回答案。
 *
 *
 */
class restoreIpAddresses_ {

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
        restoreIpAddresses_ solution = new restoreIpAddresses_();
        List<String> result = solution.restoreIpAddresses("25525511135");
        System.out.println(result);
    }
}