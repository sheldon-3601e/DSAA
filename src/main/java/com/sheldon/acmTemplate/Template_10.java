package com.sheldon.acmTemplate;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 输入描述:
 * 多个测试用例，每个测试用例一行。每行通过，隔开，有n个字符，n<100
 */

public class Template_10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String[] str = sc.nextLine().split(",");
            Arrays.sort(str);
            StringBuilder sb = new StringBuilder();

            for (String s : str) {
                sb.append(s).append(",");
            }
            System.out.println(sb.deleteCharAt(sb.length() - 1).toString());//去掉最后一个分号
        }
    }
}