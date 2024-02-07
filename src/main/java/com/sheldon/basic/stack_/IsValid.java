package com.sheldon.basic.stack_;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * @ClassName isValid
 * @Author 26483
 * @Date 2024/2/5 10:47
 * @Version 1.0
 */
public class IsValid {

    public static void main(String[] args) {
        System.out.println(isValid01("()"));
    }

    /**
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
     * <p>
     * 有效字符串需满足：
     * <p>
     * 左括号必须用相同类型的右括号闭合。
     * 左括号必须以正确的顺序闭合。
     * 每个右括号都有一个对应的相同类型的左括号。
     * <p>
     * 示例 1：
     * <p>
     * 输入：s = "()"
     * 输出：true
     * <p>
     * 思路：
     * 1.如果遇到左括号，就将对应的右括号压入栈
     * 2.如果遇到右括号，
     *      1.如果栈为空，则 return false
     *      2.将栈顶元素弹出，判断是否相等
     * 3.最后，如果栈为空，则 return true
     */
    public static boolean isValid01(String s) {
        char[] array = s.toCharArray();
        if (array.length % 2 != 0) {
            return false;
        }
        HashMap<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');
        LinkedList<Character> stack = new LinkedList<>();

        for (int i = 0; i < array.length; i++) {
            if ((array[i] == '{' || array[i] == '[' || array[i] == '(')) {
                stack.push(map.get(array[i]));
            } else{
                if (stack.isEmpty() || stack.pop() != array[i]) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

}
