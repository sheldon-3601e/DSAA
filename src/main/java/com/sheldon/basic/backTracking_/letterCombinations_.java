package com.sheldon.basic.backTracking_;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 17. 电话号码的字母组合
 * https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
 *
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 */
class letterCombinations_ {
    List<String> result = new ArrayList<>();
    StringBuilder path = new StringBuilder(); // 初始化path
    Map<Character, String> phoneMapping = new HashMap<>();
    {
        // 建立数字到字母的映射关系
        phoneMapping.put('2', "abc");
        phoneMapping.put('3', "def");
        phoneMapping.put('4', "ghi");
        phoneMapping.put('5', "jkl");
        phoneMapping.put('6', "mno");
        phoneMapping.put('7', "pqrs");
        phoneMapping.put('8', "tuv");
        phoneMapping.put('9', "wxyz");
    }

    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) {
            return result;
        }
        backtracking(digits, 0);
        return result;
    }

    void backtracking(String digits, int index) {
        if (digits.length() == index) {
            result.add(path.toString());
            return;

        }

        // 取出当前的节点
        Character item = digits.charAt(index);
        String cur = phoneMapping.get(item);
        // 遍历当前节点

        for (int i = 0; i < cur.length(); i++) {

            path.append(cur.charAt(i));
            backtracking(digits, index + 1); // 更新索引
            path.deleteCharAt(path.length() - 1); // 删除最后一个字符
        }
    }
}