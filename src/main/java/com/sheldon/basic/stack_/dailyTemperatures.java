package com.sheldon.basic.stack_;

import java.util.LinkedList;

public class dailyTemperatures {

    public static void main(String[] args) {
        int[] ints = {73, 74, 75, 71, 69, 72, 76, 73};
        dailyTemperatures dailyTemperatures = new dailyTemperatures();
        int[] ints1 = dailyTemperatures.dailyTemperatures02(ints);
        for (int i : ints1) {
            System.out.println(i);
        }
    }
    /**
     * 给定一个整数数组 temperatures ，表示每天的温度，
     * 返回一个数组 answer 其中 answer[i 是指对于第 i 天，
     * 下一个更高温度出现在几天后。如果气温在这之后都不会升高，请在该位置用 0 来代替。
     * 
     *
     */
    public int[] dailyTemperatures02(int[] temperatures) {
        int len = temperatures.length;
        LinkedList<Integer> stack = new LinkedList<>();
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int pre = stack.pop();
                res[pre] = i - pre;
            }
            stack.push(i);
        }
        return res;
    }

    /**
     * 思路：
     *      * 1.先将数组压栈
     *      * 2.遍历栈，记录位置
     *      * 3.从每个数当前位置，遍历原数组
     *      * 4.下一个比他大的数，记录两个数的坐标
     *      * 5.赋值一个新的数组
     * @param temperatures
     * @return
     */
    public int[] dailyTemperatures01(int[] temperatures) {
        int len = temperatures.length;
        int index = len - 1;
        LinkedList<Integer> stack = new LinkedList<>();
        int[] newInts = new int[len];
        for (int item : temperatures ) {
            stack.push(item);
        }
        while(!stack.isEmpty()) {
            int num = stack.pop();
            for (int i = len - 1;i > index ;i-- ) {
                if (num < temperatures[i]) {
                    newInts[index] = i - index;
                }
            }
            index--;
        }
        return newInts;
    }
}