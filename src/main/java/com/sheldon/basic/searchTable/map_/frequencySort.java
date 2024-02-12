package com.sheldon.basic.searchTable.map_;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个字符串 s ，根据字符出现的 频率 对其进行 降序排序 。一个字符出现的 频率 是它出现在字符串中的次数。
 * <p>
 * 返回 已排序的字符串 。如果有多个答案，返回其中任何一个。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "tree"
 * 输出: "eert"
 * 解释: 'e'出现两次，'r'和't'都只出现一次。
 * 因此'e'必须出现在'r'和't'之前。此外，"eetr"也是一个有效的答案。
 * <p>
 * 链接：https://leetcode.cn/leetbook/read/all-about-lockup-table/fc4ic/
 */

public class frequencySort {

    public String frequencySort02(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char item : s.toCharArray()) {
            map.put(item, map.getOrDefault(item, 0) + 1);
        }
        List<Character> list = new ArrayList<>(map.keySet());
        for (char item : s.toCharArray()) {
            Integer num = map.get(item);
            list.add(num, item);
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = list.size() - 1; i > 0; i--) {
            Character cur = list.get(i);
            if (cur != null) {
                Integer num = map.get(cur);
                for (int j = 0; j < num; j++) {
                    stringBuilder.append(cur);
                }
            }
        }
        return stringBuilder.toString();
    }

    public String frequencySort01(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char item : s.toCharArray()) {
            map.put(item, map.getOrDefault(item, 0) + 1);
        }
        List<Character> list = new ArrayList<>(map.keySet());
        list.sort((a, b) -> map.get(b) - map.get(a));
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            char key = list.get(i);
            int num = map.get(key);
            for (int j = 0; j < num; j++) {
                stringBuilder.append(key);
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        frequencySort frequencySort = new frequencySort();
        String s = "tree";
        System.out.println(frequencySort.frequencySort02(s));
    }
}