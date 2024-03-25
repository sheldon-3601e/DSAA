package com.sheldon.acmTemplate;

import java.util.Scanner;

/**
 * 输入描述：
 * 输入数据有多组，每行表示一组输入数据。
 * 每行的第一个整数为整数的个数n(1<=n<= 100)。
 * 接下来n个正整数，即需要求和的每个正整数。
 */

public class Template_06 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextInt()){ //或者使用hasNext()
            int num = sc.nextInt();
            int sum = 0;
            while(num-->0){
                sum += sc.nextInt();
            }
            System.out.println(sum);
        }
    }
}
 