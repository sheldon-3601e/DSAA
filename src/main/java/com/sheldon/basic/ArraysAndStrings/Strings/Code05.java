package com.sheldon.basic.ArraysAndStrings.Strings;

/**
 * @ClassName Code05
 * @Author 26483
 * @Date 2024/1/20 13:33
 * @Version 1.0
 *  
 */
public class Code05 {

    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

    public static void main(String[] args) {
        Code05 code05 = new Code05();
        int i = code05.strStr("sadbutsad", "sad");
        System.out.println(i);
    }

}
