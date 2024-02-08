package com.sheldon.basic.stack_.review;

import java.util.ArrayDeque;

public class decodeString {
    public String decodeString01(String s) {
        // 存储循环次数的栈
        ArrayDeque<Integer> countStack = new ArrayDeque<>();
        // 存储字符串的栈
        ArrayDeque<StringBuilder> stringStack = new ArrayDeque<>();
        // 存储要循环的字符串
        StringBuilder currentString = new StringBuilder();
        // 存储循环次数
        int count = 0;

        // 遍历字符串数组
        for (char ch : s.toCharArray()) {
            // 如果是数字，将数字字符转换为数字
            if (Character.isDigit(ch)) {
                count = count * 10 + (ch - '0');
            } else if (ch == '[') {
                countStack.push(count);
                stringStack.push(currentString);
                // 将循环次数和字符串重置
                count = 0;
                currentString = new StringBuilder();
            } else if (ch == ']') {
                // 当前的字符串
                StringBuilder decodedString = stringStack.pop();
                int repeatTimes = countStack.pop();
                for (int i = 0; i < repeatTimes; i++) {
                    // 将要循环的字符串重复 repeatTimes 次
                    // 并将结果添加到当前的字符串中
                    decodedString.append(currentString);
                }
                currentString = decodedString;
            } else {
                // 将字符添加到当前的字符串中
                currentString.append(ch);
            }
        }

        return currentString.toString();
    }

    public static void main(String[] args) {
        decodeString ds = new decodeString();
        String s = "3[a]2[bc]";
        System.out.println(ds.decodeString01(s));
    }

}
