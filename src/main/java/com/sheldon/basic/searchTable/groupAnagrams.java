package com.sheldon.basic.searchTable;

import java.util.*;

/**
 * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 * <p>
 * 字母异位词 是由重新排列源单词的所有字母得到的一个新单词。
 * <p>
 * 示例 1:
 * <p>
 * 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
 * <p>
 * 链接：https://leetcode.cn/leetbook/read/all-about-lockup-table/xhofoh/
 *
 */

class groupAnagrams {
    public List<List<String>> groupAnagrams01(String[] strs) {
        // key - 排序后的字符串, val - 字符串对应的结果集
        Map<String, List<String>> map = new HashMap<>();
        List<List<String>> list = new ArrayList<>();

        for (String str : strs ) {
            // 将字符串进行排序
            char[] temp = str.toCharArray();
            Arrays.sort(temp);
            String s = new String(temp);
            // 如果结果集不包含字符串，就添加
            if (!map.containsKey(s)) {
                map.put(s, new ArrayList<>());
            }
            map.get(s).add(str);
        }

        for (String key : map.keySet() ) {
            list.add(map.get(key));
        }

        return list;
    }

    public static void main(String[] args) {
        groupAnagrams groupAnagrams = new groupAnagrams();
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> res = groupAnagrams.groupAnagrams01(strs);
        for (List<String> list : res) {
            for (String item : list) {
                System.out.println(item);
            }
        }
    }
}