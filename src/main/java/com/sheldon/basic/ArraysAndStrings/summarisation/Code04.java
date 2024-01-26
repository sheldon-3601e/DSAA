package com.sheldon.basic.ArraysAndStrings.summarisation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName Code04
 * @Author 26483
 * @Date 2024/1/25 9:22
 * @Version 1.0
 * @Description TODO
 */
public class Code04 {

    /**
     * 给定一个字符串 s ，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
     *
     *  
     *
     * 示例 1：
     *
     * 输入：s = "Let's take LeetCode contest"
     * 输出："s'teL ekat edoCteeL tsetnoc"
     *
     *
     * @param s
     * @return
     */

    public String reverseWords01(String s) {
        String[] split = s.split(" ");
        List<String> list = new ArrayList<>(split.length);

        for (String item : split) {
            StringBuilder reverse = new StringBuilder(item).reverse();
            list.add(reverse.toString());
        }
        return String.join(" ", list);
    }

    /**
     * 使用了 Java 8 引入的流式操作和 Lambda 表达式。
     * Arrays.stream(s.split(" ")) 将字符串按空格分割并创建一个流，
     * 然后使用 map 操作对每个单词进行反转操作，
     * 最后使用 Collectors.joining(" ") 将结果连接为一个字符串，以空格分隔。
     *
     * @param s
     * @return
     */
    public String reverseWords02(String s) {
        return Arrays.stream(s.split(" "))
                .map(word -> new StringBuilder(word).reverse().toString())
                .collect(Collectors.joining(" "));
    }



    public static void main(String[] args) {
        String s = "the sky is blue";
        Code04 code04 = new Code04();
        // 比较两个方法的执行时间
        long start1 = System.currentTimeMillis();
        String s1 = code04.reverseWords01(s);
        long end1 = System.currentTimeMillis();
        System.out.println("方法一执行时间：" + (end1 - start1) + "ms");

        long start2 = System.currentTimeMillis();
        String s2 = code04.reverseWords02(s);
        long end2 = System.currentTimeMillis();
        System.out.println("方法二执行时间：" + (end2 - start2) + "ms");
        System.out.println(s1);
        System.out.println(s2);

    }

}
