package com.sheldon.acmTemplate;

import java.util.Scanner;

/**
 * 输入两个正整数，包括多组数据，对于每组数据输出两个整数的和
 * 带有结束标志
 */

public class Template_03 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            int a = in.nextInt();
            int b = in.nextInt();
            if (a == 0 && b == 0) {
                break;
            }
            System.out.println(a + b);
        }
    }
}