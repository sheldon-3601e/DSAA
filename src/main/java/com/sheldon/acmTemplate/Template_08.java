package com.sheldon.acmTemplate;

import java.util.Arrays;
import java.util.Scanner;

public class Template_08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 读取第一行输入，即整数n
        int n = scanner.nextInt();
        scanner.nextLine(); // 消耗掉换行符

        // 读取第二行输入，即n个字符串，字符串之间由空格分隔
        String line = scanner.nextLine();

        // 将这些字符串存储到一个数组中
        String[] strings = line.split(" ");

        // 对数组中的字符串进行排序
        Arrays.sort(strings);

        // 输出排序后的字符串，用空格分隔
        StringBuilder result = new StringBuilder();
        for (String str : strings) {
            result.append(str).append(" ");
        }

        // 删除最后一个字符，即最后一个空格
        result.deleteCharAt(result.length() - 1);

        System.out.println(result.toString());

        scanner.close();
    }
}
