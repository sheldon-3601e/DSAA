package com.sheldon.acmTemplate;

import java.util.Scanner;

/**
 * 输入描述
 * 输入的第一行包括一个正整数t(1<=t<= 100)，表示数据组数。
 * 接下来t行，每行一组数据。
 * 每行的第一个整数为整数的个数n(1<=n<=100)°接下来n个正整数，即需要求和的每个正整数。
 */

public class Template_05 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        while(num-->0){
            int a = sc.nextInt();
            int sum = 0;
            for(int i = 0; i < a; i++){
                sum += sc.nextInt();
            }
            System.out.println(sum);
        }
    }
}