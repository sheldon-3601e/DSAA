package com.sheldon.acmTemplate;

import java.util.Scanner;

/**
 * 输入两个正整数，包括多组数据，对于每组数据输出两个整数的和
 */
public class Template_01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            System.out.println(a + b);
        }
    }
}