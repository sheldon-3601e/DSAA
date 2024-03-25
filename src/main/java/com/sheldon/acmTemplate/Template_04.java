package com.sheldon.acmTemplate;

import java.util.Scanner;

/**
 * 输入描述
 * 输入包括多组测试数据。
 * 每组测试数据包括两行：
 * 第一行包括一个正整数n(1<=n<=100)，表示一共有n个数；
 * 第二行包括n个正整数，每个数不超过100。
 * 求出每组测试数据的和并输出。
 */
public class Template_04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            int num = sc.nextInt();
            int sum = 0;
            for (int i = 0; i < num; i++) {
                sum += sc.nextInt();
            }
            if (num == 0) {
                break;
            }
            System.out.println(sum);
        }
    }
}