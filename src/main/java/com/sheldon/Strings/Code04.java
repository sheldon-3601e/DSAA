package com.sheldon.Strings;

/**
 * @ClassName Code04
 * @Author 26483
 * @Date 2024/1/20 13:06
 * @Version 1.0
 * @Description TODO
 */
public class Code04 {

    public String reverseWords(String s) {
        String[] split = s.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = split.length - 1; i >= 0; i--) {
            if (!split[i].isEmpty()) {
                stringBuilder.append(split[i]).append(" ");
            }
        }
        // trim() 方法用于删除字符串的头尾空白符。
        return stringBuilder.toString().trim();
    }

    public static void main(String[] args) {
        Code04 code04 = new Code04();
        String s = code04.reverseWords("  hello world  ");
        System.out.println(s);
    }

}
