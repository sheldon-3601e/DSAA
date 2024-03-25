package com.sheldon.HotTopic;

import java.util.HashSet;
import java.util.Set;

class LengthOfLongestSubstring_08 {
    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        int left = 0;
        int right = 0;
        Set set = new HashSet();
        int result = 0;

        while (right < chars.length) {
            // 可以采用移动窗口的方法
            // 维持一个 set 集合，用来存放不重复的字符
            // 如果不重复则移动右指针
            // 如果重复了就移动左指针
            if (!set.contains(chars[right])) {
                set.add(chars[right]);
                right++;
                // 更新集合长度
                result = Math.max(result, set.size());
            } else {
                // 如果出现了重复，就移动左指针，去掉重复的元素，继续向右移动
                set.remove(chars[left]);
                left++;
            }
        }
        return result;
    }
}