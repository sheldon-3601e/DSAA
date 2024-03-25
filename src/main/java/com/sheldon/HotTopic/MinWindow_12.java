package com.sheldon.HotTopic;

import java.util.HashMap;
import java.util.Map;

/**
 * 76. 最小覆盖子串
 * 给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字符的最小子串。
 * 链接：https://leetcode-cn.com/problems/minimum-window-substring/
 */
class MinWindow_12 {
    public String minWindow(String s, String t) {
        if (s == null || s.length() == 0 || t == null || t.length() == 0) {
            return "";
        }

        // 统计字符串 t 中每个字符的出现次数
        Map<Character, Integer> targetCount = new HashMap<>();
        for (char c : t.toCharArray()) {
            targetCount.put(c, targetCount.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0;
        // 记录字串最小长度
        int minLength = Integer.MAX_VALUE;
        // 记录字串的最小长度的起始位置
        int minLeft = 0;
        int remaining = t.length(); // 记录窗口内尚未匹配的字符数量

        while (right < s.length()) {
            char rightChar = s.charAt(right);
            // 如果右指针的字符属于字符串 t，则更新 targetCount 和 remaining
            if (targetCount.containsKey(rightChar)) {
                // 如果 targetCount 中该字符的数量大于 0，说明当前窗口内，没有该字符的匹配
                if (targetCount.get(rightChar) > 0) {
                    // 未匹配的数量减一
                    remaining--;
                }
                // 更新 targetCount 中该字符的数量，即说明当前窗口内，存在该字符的匹配
                targetCount.put(rightChar, targetCount.get(rightChar) - 1);
            }

            // 当 remaining == 0 时，说明当前窗口内，存在所有匹配字符
            // 开始缩小左指针，即将已经匹配的字符排除在外，继续寻找下一个匹配他的窗口
            while (remaining == 0) {
                // 更新最小长度和最小长度的起始位置
                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    minLeft = left;
                }
                // 得到左指针的字符
                char leftChar = s.charAt(left);
                // 如果左指针的字符属于字符串 t，则更新 targetCount 和 remaining
                if (targetCount.containsKey(leftChar)) {
                    // 缩小左指针，即说明当前窗口不存在该字符了
                    // 所以将 targetCount 中该字符的数量加一
                    targetCount.put(leftChar, targetCount.get(leftChar) + 1);
                    // 如果 targetCount 中该字符的数量大于 0，说明当前窗口内，没有该字符的匹配
                    if (targetCount.get(leftChar) > 0) {
                        // 未匹配的数量加一
                        remaining++;
                    }
                }
                left++;
            }
            right++;
        }

        return minLength == Integer.MAX_VALUE ? "" : s.substring(minLeft, minLeft + minLength);
    }

    public static void main(String[] args) {
        MinWindow_12 minWindow = new MinWindow_12();
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(minWindow.minWindow(s, t));
    }
}