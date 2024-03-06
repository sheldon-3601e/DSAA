package com.sheldon.basic.backTracking_;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 131. 分割回文串
 * https://leetcode-cn.com/problems/palindrome-partitioning/
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
 *
 * 回文串 是正着读和反着读都一样的字符串。
 */
class partition_ {

    List<List<String>> result = new ArrayList<>();
    LinkedList<String> path = new LinkedList<>();
    public List<List<String>> partition(String s) {

        backtracking(s, 0);
        return result;
    }

    void backtracking(String s, int startIndex) {
        if(startIndex >= s.length()) {
            result.add(new ArrayList(path));
            return;
        }

        for(int i = startIndex; i < s.length(); i++) {
            // 如果是回文串
            if(isPalindrome(s,startIndex, i)) {
                String cur = s.substring(startIndex, i + 1);
                path.add(cur);
            } else {
                continue;
            }
            backtracking(s, i+1);
            path.removeLast();
        }
    }

    boolean isPalindrome(String count, int start, int end) {
        for(int i = start, j = end; i < j; i++, j--) {
            if(count.charAt(i) != count.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        partition_ solution = new partition_();
        List<List<String>> result = solution.partition("aab");
        System.out.println(result);
    }
}