package com.sheldon.basic.map_;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定两个字符串 s 和 t ，判断它们是否是同构的。
 * <p>
 * 如果 s 中的字符可以按某种映射关系替换得到 t ，那么这两个字符串是同构的。
 * <p>
 * 每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。
 * <p>
 * 不同字符不能映射到同一个字符上，相同字符只能映射到同一个字符上，字符可以映射到自己本身。
 * <p>
 * 链接：https://leetcode.cn/leetbook/read/all-about-lockup-table/f1f86/
 */

public class isIsomorphic {

    // 解决不能多个字符映射到同一个字符上的问题
    // 需要使用两个map来存储映射关系
    // 这时可以达到一个双向绑定的效果
    public boolean isIsomorphic02(String s, String t) {
        Map <Character,Character> map1= new HashMap<>();
        Map <Character,Character> map2= new HashMap<>();
        int n=s.length();
        for(int i=0;i<n;i++){
            char ch1=s.charAt(i);
            char ch2=t.charAt(i);
            if(map1.containsKey(ch1)&&map1.get(ch1)!=ch2){
                return false;
            }
            if(map2.containsKey(ch2)&&map2.get(ch2)!=ch1){
                return false;
            }
            map1.put(ch1,ch2);
            map2.put(ch2,ch1);
        }
        return true;

    }

    // 无法解决不能多个字符映射到一个字符的问题
    public boolean isIsomorphic01(String s, String t) {
        Map<Character, Character> map = new HashMap<>();
        char[] s1 = s.toCharArray();
        char[] s2 = t.toCharArray();
        // 同时遍历两个字符串
        for (int i = 0; i < s1.length ; i++ ) {
            // 如果 map 中存在 s1，就验证映射关系
            if (map.containsKey(s1[i])) {
                if (!(s2[i] == map.get(s1[i]))) {
                     return false;       
                }
                continue;    
            }
            // 如果不存在，则添加映射关系
            map.put(s1[i], s2[i]);
        }      
        return true;
    }

    public static void main(String[] args) {
        isIsomorphic isIsomorphic = new isIsomorphic();
        String s = "badc";
        String t = "baba";
        System.out.println(isIsomorphic.isIsomorphic02(s, t));
    }
}