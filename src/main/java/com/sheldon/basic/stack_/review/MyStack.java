package com.sheldon.basic.stack_.review;

import java.util.ArrayDeque;

/**
 * 请你仅使用两个队列实现一个后入先出（LIFO）的栈，并支持普通栈的全部四种操作（push、top、pop 和 empty）。<br>
 *
 * 实现 MyStack 类：<br>
 *
 * void push(int x) 将元素 x 压入栈顶。<br>
 * int pop() 移除并返回栈顶元素。<br>
 * int top() 返回栈顶元素。<br>
 * boolean empty() 如果栈是空的，返回 true ；否则，返回 false 。<br>
 *  
 *
 * 注意：<br>
 *
 * 你只能使用队列的基本操作 —— 也就是 push to back、peek/pop from front、size 和 is empty 这些操作。<br>
 * 你所使用的语言也许不支持队列。 你可以使用 list （列表）或者 deque（双端队列）来模拟一个队列 , 只要是标准的队列操作即可。<br>
 *
 */

class MyStack {

    private static ArrayDeque<Integer> queue;

    public MyStack() {
        queue = new ArrayDeque<>();
    }

    public void push(int x) {
        queue.offer(x);
    }

    public int pop() {
        moveQueue();
        return queue.poll();
    }

    public int top() {
        moveQueue();
        int top = queue.peek();
        queue.offer(queue.poll());
        return top;
    }

    public boolean empty() {
        return queue.isEmpty();
    }

    private static void moveQueue() {
        for (int i = 0; i < queue.size() - 1; i++) {
            queue.offer(queue.poll());
        }
    }

}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */