package com.sheldon.basic.stack_;

import java.util.ArrayList;

/**
 * @ClassName MinStack
 * @Author 26483
 * @Date 2024/2/5 10:26
 * @Version 1.0
 * <p>
 * <p>
 * 实现 MinStack 类:
 * MinStack() 初始化堆栈对象
 * void push(int val) 将元素val推入堆栈。
 * void pop() 删除堆栈顶部的元素。
 * int top() 获取堆栈顶部的元素。
 * int getMin() 获取堆栈中的最小元素。
 */
public class MinStack {
    ArrayList<Integer> list;
    int min;

    public MinStack() {
        list = new ArrayList<>();
        min = Integer.MAX_VALUE; // 初始化最小值为最大值
    }

    public void push(int val) {
        list.add(val);
        min = Math.min(min, val);
    }

    public void pop() {
        if (!list.isEmpty()) {
            int del = list.remove(list.size() - 1); // 删除栈顶元素
            if (del == min) { // 如果删除的是最小值
                min = Integer.MAX_VALUE; // 重新设置最小值为最大值
                for (int item : list) {
                    min = Math.min(item, min); // 重新找到最小值
                }
            }
        }
    }

    public int top() {
        if (!list.isEmpty()) {
            return list.get(list.size() - 1); // 返回栈顶元素
        }
        return -1; // 栈为空，返回-1
    }

    public int getMin() {
        return min;
    }

}
