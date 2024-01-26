package com.sheldon.basic.ArraysAndStrings.Strings;

/**
 * @ClassName Code03
 * @Author 26483
 * @Date 2024/1/20 0:07
 * @Version 1.0
 * @Description TODO
 */
public class Code03 {
    /**
     * 给你一个字符串 s，找到 s 中最长的回文子串。
     *
     * 如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。
     *
     *  
     *
     * 示例 1：
     *
     * 输入：s = "babad"
     * 输出："bab"
     * 解释："aba" 同样是符合题意的答案。
     *
     * @param s
     * @return
     */

//    public String longestPalindrome(String s) {
//        // 循环取出字符，判断它是否是回文数
//        // 如果是，再判断长度是否大于当前回文数
//        // 如果是，更新回文数
//        // 如果不是，继续循环
//        if (s == null || s.isEmpty()) {
//            return "";
//        }
//        if (s.length() == 1) {
//            return s;
//        }
//
//        String result = "";
//        int length = 0;
//
//        for (int i = 0; i < s.length(); i++) {
//            String temp = "";
//            for (int j = i + 1; j <= s.length() ; j++) {
//                temp = s.substring(i, j);
//                if (isPalindrome(temp)) {
//                    if (temp.length() > length) {
//                        result = temp;
//                        length = temp.length();
//                    }
//                }
//            }
//        }
//        return result;
//    }
//
//    private boolean isPalindrome(String temp) {
//        StringBuilder stringBuilder = new StringBuilder();
//        for (int i = temp.length() - 1; i >= 0; i--) {
//            stringBuilder.append(temp.charAt(i));
//        }
//        return stringBuilder.toString().equals(temp);
//    }

    public String longestPalindrome(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }

        int start = 0;
        int end = 0;

        for (int i = 0; i < s.length(); i++) {
            // 以当前字符为中心的奇数长度回文子串
            int len1 = expandAroundCenter(s, i, i);
            // 以当前字符和下一个字符的中间为中心的偶数长度回文子串
            int len2 = expandAroundCenter(s, i, i + 1);

            // 取两种情况下的最大回文子串长度
            int len = Math.max(len1, len2);

            // 如果当前回文子串长度大于已知最大回文子串长度
            if (len > end - start) {
                // 更新最大回文子串的起始和结束位置
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }

        // 返回最大回文子串
        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        // 扩展中心并检查回文
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        // 返回当前回文子串的长度
        return right - left - 1;
    }


    public static void main(String[] args) {
        Code03 code03 = new Code03();
        // 记录当下运行时长
        long start = System.currentTimeMillis();
        String s = code03.longestPalindrome("\"bbbb\"");
        long end = System.currentTimeMillis();
        // 以毫秒的形式打印运行时长
        System.out.println(end - start);
        System.out.println(s);
    }

}
