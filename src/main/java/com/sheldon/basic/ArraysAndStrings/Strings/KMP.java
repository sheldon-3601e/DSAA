
package com.sheldon.basic.ArraysAndStrings.Strings;
/**
 * @ClassName KMP
 * @Author 26483
 * @Date 2024/1/20 16:52
 * @Version 1.0
 * @Description KMP算法
 */
public class KMP {

    // 构建部分匹配表
    public static int[] buildPartialMatchTable(String text) {
        int[] table = new int[text.length()];
        int j = 0;

        for (int i = 1; i < text.length(); i++) {
            // 当模式串中的字符不匹配时，回溯到之前已匹配部分的位置
            while (j > 0 && text.charAt(i) != text.charAt(j)) {
                j = table[j - 1];
            }

            // 如果模式串中的字符匹配，增加已匹配部分的长度
            if (text.charAt(i) == text.charAt(j)) {
                j++;
            }

            // 记录当前位置的部分匹配值
            table[i] = j;
        }

        // 返回构建好的部分匹配表
        return table;
    }

    // KMP算法的搜索过程
    public static int kmpSearch(String text, String pattern) {
        int[] table = buildPartialMatchTable(text);
        int j = 0;

        for (int i = 0; i < text.length(); i++) {
            // 当文本串和模式串中的字符不匹配时，回溯到之前已匹配部分的位置
            while (j > 0 && text.charAt(i) != pattern.charAt(j)) {
                j = table[j - 1];
            }

            // 如果文本串和模式串中的字符匹配，增加已匹配部分的长度
            if (text.charAt(i) == pattern.charAt(j)) {
                j++;
            }

            // 如果已匹配的长度等于模式串的长度，说明找到了匹配
            if (j == pattern.length()) {
                return i - j + 1;  // 返回匹配的起始位置
            }
        }

        return -1;  // 没有找到匹配
    }

    public static void main(String[] args) {
        String text = "SDSDDAFDFDSASSD";
        String pattern = "DA";

        // 使用KMP算法进行搜索
        int result = kmpSearch(text, pattern);

        // 输出搜索结果
        if (result != -1) {
            System.out.println("在位置 " + result + " 处找到匹配");
        } else {
            System.out.println("未找到匹配");
        }
    }
}
