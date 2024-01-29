package com.sheldon.basic.ArraysAndStrings.Strings;

/**
 * @ClassName Code02
 * @Author 26483
 * @Date 2024/1/19 23:19
 * @Version 1.0
 *  
 */
public class Code02 {
    public String longestCommonPrefix(String[] strs) {
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
        Code02 code02 = new Code02();
        String s = code02.longestCommonPrefix(strs);
        System.out.println(s);
    }
}
