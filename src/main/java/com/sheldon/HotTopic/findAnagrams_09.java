package com.sheldon.HotTopic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 438. 找到字符串中所有字母异位词
 * 给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。
 * 字母异位词指字母相同，但排列不同的字符串。
 * 链接：https://leetcode-cn.com/problems/find-all-anagrams-in-a-string
 */
class findAnagrams_09 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.length() == 0 || p == null || p.length() == 0 || s.length() < p.length())
            return result;

        // 统计字符串 p 中每个字符的出现次数
        Map<Character, Integer> charCountP = new HashMap<>();
        for (char c : p.toCharArray()) {
            charCountP.put(c, charCountP.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0;
        int count = 0; // 记录窗口内匹配的字符数
        Map<Character, Integer> charCountS = new HashMap<>();

        while (right < s.length()) {
            char rightChar = s.charAt(right);
            if (charCountP.containsKey(rightChar)) {
                charCountS.put(rightChar, charCountS.getOrDefault(rightChar, 0) + 1);
                // 当窗口内字符的出现次数不超过 p 中对应字符的出现次数时，count++
                if (charCountS.get(rightChar) <= charCountP.get(rightChar)) {
                    count++;
                }
            }

            // 缩小窗口
            while (count == p.length()) {
                // 当窗口大小等于 p 的长度且窗口内的字符都是异位词时，将起始索引加入结果列表
                if (right - left + 1 == p.length()) {
                    result.add(left);
                }
                char leftChar = s.charAt(left);
                if (charCountP.containsKey(leftChar)) {
                    charCountS.put(leftChar, charCountS.get(leftChar) - 1);
                    // 当窗口内字符的出现次数小于 p 中对应字符的出现次数时，count--
                    if (charCountS.get(leftChar) < charCountP.get(leftChar)) {
                        count--;
                    }
                }
                left++;
            }

            right++;
        }

        return result;
    }

    public static void main(String[] args) {
        findAnagrams_09 solution = new findAnagrams_09();
        String s = "cbaebabacd";
        String p = "abc";
        List<Integer> result = solution.findAnagrams(s, p);
        System.out.println(result);
    }
}