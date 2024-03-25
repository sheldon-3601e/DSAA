package com.sheldon.acmTemplate;

import java.util.Scanner;
public class Template_07 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            int sum = 0;
            String[] arr = sc.nextLine().split(" ");
            for(String str:arr){
                sum += Integer.parseInt(str);
            }
            System.out.println(sum);
        }
    }
}