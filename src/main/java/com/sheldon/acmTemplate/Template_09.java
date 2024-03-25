package com.sheldon.acmTemplate;

import java.util.*;

/**
 * 输入描述
 * 输入数据有多组，每行表示一组输入数据。
 * 对于每组测试用例，输出一行排席过的字符串，每个字符串通过空格隔开
 */

public class Template_09 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            String[] str = sc.nextLine().split(" ");
            Arrays.sort(str);
            StringBuffer sb = new StringBuffer();
            for(String s:str){
                sb.append(s).append(" ");
            }
            System.out.println(sb.substring(0,sb.length()-1)); //去掉最后一个空格
}
    }
}