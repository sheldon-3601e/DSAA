package com.sheldon.basic.set_;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 编写一个算法来判断一个数 n 是不是快乐数。
 * <p>
 * 「快乐数」 定义为：
 * <p>
 * 对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
 * 然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
 * 如果这个过程 结果为 1，那么这个数就是快乐数。
 * 如果 n 是 快乐数 就返回 true ；不是，则返回 false 。
 * <p>
 * 链接：https://leetcode.cn/leetbook/read/all-about-lockup-table/fqqcs/
 */
public class isHappy {
    /**
     * 思路：利用 Set 集合不能添加相同元素的特性
     * 当 Set 集合中出现重复元素时，说明进入了循环，返回 false
     *
     * @param n
     * @return
     */
    public boolean isHappy01(int n) {
        Set<Integer> visited = new HashSet<>();
        while (true) {
            int sum = 0;
            while (n != 0) {
                int digit = n % 10;
                sum += digit * digit;
                n /= 10;
            }
            if (sum != 1 ) {
                if (!visited.add(sum)) {
                    return false;
                }
                n = sum;
            } else {
                return true;
            }
        }
    }

    public static void main(String[] args) {
        isHappy isHappy = new isHappy();
        System.out.println(isHappy.isHappy01(19));
    }
}