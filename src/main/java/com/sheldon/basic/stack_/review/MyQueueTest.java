package com.sheldon.basic.stack_.review;

/**
 * @ClassName MyQueueTest
 * @Author 26483
 * @Date 2024/2/8 17:10
 * @Version 1.0
 * @Description TODO
 */
public class MyQueueTest {
    public static void main(String[] args) {
        MyQueue obj = new MyQueue();
        obj.push(1);
        obj.push(2);
        obj.push(3);
        obj.push(4);
        int param_2 = obj.pop();
        int param_3 = obj.peek();
        boolean param_4 = obj.empty();
        System.out.println(param_2);
        System.out.println(param_3);
        System.out.println(param_4);
    }
}
