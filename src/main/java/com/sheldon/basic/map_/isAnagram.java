package com.sheldon.basic.map_;

import java.util.HashMap;
import java.util.Map;

class isAnagram {
    public boolean isAnagram01(String s, String t) {
        if (s.length() != t.length() ) {
            return false;
        }
        Map<Character, Integer> map = new HashMap<>();
        char[] s1 = s.toCharArray();
        char[] s2 = t.toCharArray();
        for (char item : s1 ) {
            map.put(item, map.getOrDefault(item, 0) + 1);
        }
        for (char item : s2 ) {
            if ( !map.containsKey(item) || map.get(item) < 1) {
                return false;
            }
            map.put(item, map.get(item) - 1);
        }
        return true;
    }

    public boolean isAnagram02(String s, String t) {
        if (s.length() != t.length() ) {
            return false;
        }
        Map<Character, Integer> map01 = new HashMap<>();
        Map<Character, Integer> map02 = new HashMap<>();
        for (char item : s.toCharArray() ) {
            map01.put(item, map01.getOrDefault(item, 0) + 1);
        }
        for (char item : t.toCharArray() ) {
            map02.put(item, map02.getOrDefault(item, 0) + 1);
        }
        return map01.equals(map02);
    }

    public static void main(String[] args) {
        isAnagram isAnagram = new isAnagram();
        String s = "rat";
        String t = "cat";
        System.out.println(isAnagram.isAnagram01(s, t));
    }
}