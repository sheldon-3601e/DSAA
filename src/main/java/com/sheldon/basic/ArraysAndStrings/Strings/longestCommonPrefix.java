package com.sheldon.basic.ArraysAndStrings.Strings;

import java.util.Arrays;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：strs = ["flower","flow","flight"]
 * 输出："fl"
 * 示例 2：
 * <p>
 * 输入：strs = ["dog","racecar","car"]
 * 输出：""
 * 解释：输入不存在公共前缀。
 * <p>
 * 作者：LeetCode
 * 链接：https://leetcode.cn/leetbook/read/array-and-string/ceda1/
 *
 */
public class longestCommonPrefix {

    public String longestCommonPrefix02(String[] strs) {
        Arrays.sort(strs);
        String first = strs[0];
        int i = 0;
        for (; i < first.length(); i++) {
            if (!isValid(i, strs)) {
                break;
            }
        }
        return first.substring(0, i);
    }
    public static boolean isValid(int i, String[] strs) {
        char index = strs[0].charAt(i);
        for(String str : strs) {
            if(str.charAt(i) != index) {
                return false;
            }
        }
        return true;
    }

    public String longestCommonPrefix01(String[] strs) {
        if(strs == null || strs.length == 0){
            return "";
        }
        // 纵向扫描：遍历第一个字符串的字符，并与其余字符串相应位置的字符比较
        for(int i = 0; i < strs[0].length(); i++){
            // 获取第一个字符串的第 i 个字符
            char c = strs[0].charAt(i);

            for(int j = 0; j < strs.length; j++){
                // 两种情况中断循环
                // 1. 第 j 个字符串的长度已经到达 i，
                // 即第 j 个字符串就是最长前缀
                // 2. 当前第 j 个字符串的第 i 个字符与第一个字符串的第 i 个字符不相等，
                // 即 strs[0].substring(0, i) 就是最长前缀
                if(i == strs[j].length() || strs[j].charAt(i) != c){
                    return strs[0].substring(0, i);
                }
            }
        }
        // 循环正常结束，说明 strs[0] 就是最长前缀
        return strs[0];
    }

    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};
        longestCommonPrefix code02 = new longestCommonPrefix();
        String s = code02.longestCommonPrefix02(strs);
        System.out.println(s);
    }
}
