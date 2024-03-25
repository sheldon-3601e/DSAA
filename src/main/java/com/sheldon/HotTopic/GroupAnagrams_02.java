package com.sheldon.HotTopic;

import java.util.*;

/**
 * 49. 字母异位词分组
 * 链接：https://leetcode-cn.com/problems/group-anagrams/
 */

class GroupAnagrams_02 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> res = new HashMap<>();
        for (String str : strs) {
            // 获得排序后的字符串
            String sortedStr = sortString(str);
            // 如果 map 中不存在这个 key，那么就添加
            if (!res.containsKey(sortedStr)) {
                res.put(sortedStr, new ArrayList<>());
            }
            // 如果存在，就直接添加到对应的 list 中
            res.get(sortedStr).add(str);
        }
        return new ArrayList<>(res.values());
    }

    // 辅助方法，用于对字符串进行排序
    private static String sortString(String str) {
        char[] charArray = str.toCharArray();
        java.util.Arrays.sort(charArray);
        return new String(charArray);
    }

}