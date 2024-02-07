package com.sheldon.basic.stack_;

/**
 * @ClassName MinStackTest
 * @Author 26483
 * @Date 2024/2/5 10:37
 * @Version 1.0
 * @Description TODO
 */
public class MinStackTest {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }
}
