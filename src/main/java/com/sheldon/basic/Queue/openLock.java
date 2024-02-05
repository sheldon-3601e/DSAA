package com.sheldon.basic.Queue;

import java.util.*;

/**
 * @ClassName openLock
 * @Author 26483
 * @Date 2024/2/4 11:21
 * @Version 1.0
 * @Description TODO
 */
public class openLock {

    public static void main(String[] args) {
        String[] deadends = {"0201", "0101", "0102", "1212", "2002"};
        String target = "0202";
        System.out.println(openLockTest(deadends, target));
    }

    /**
     * 思路： BFS
     * 1.先将初始密码输入队列
     * 2.循环队列
     * 3.每次取出一个数
     * 4.如果key not in 死亡队列
     * 5.则step++，将key的下四个key存入队列
     * 6.如果该 key == target ，则 return step
     * 7.否则 return -1
     */

    public static int openLockTest(String[] deadends, String target) {
        // 死亡密码集合
        Set<String> deadSet = new HashSet<>();
        deadSet.addAll(Arrays.asList(deadends));

        if (deadSet.contains("0000")) {
            return -1; // 初始状态就在死亡列表中，无法解锁
        }

        Queue<String> queue = new LinkedList<>();
        // 存储已经验证过的密码
        Set<String> visited = new HashSet<>();
        queue.offer("0000");
        visited.add("0000");
        int steps = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String current = queue.poll();

                if (current.equals(target)) {
                    return steps;
                }

                for (int j = 0; j < 4; j++) {
                    for (int k = -1; k <= 1; k += 2) {
                        // 转化成字符串数组
                        char[] currentArray = current.toCharArray();
                        /**
                         * currentArray[j]：获取锁当前位置 j 的字符表示。
                         *
                         * - '0'：从字符表示的数字中减去字符 '0'。在Java中，字符被表示为Unicode值，字符'0'到'9'的Unicode值是连续的（48到57）。
                         * 因此，减去 '0' 实际上将数字的字符表示转换为相应的整数值。例如，如果 currentArray[j] 是 '5'，减去 '0' 将得到整数 5。
                         *
                         * + k：加上 k 的值。在锁组合的上下文中，k 表示数字的变化（要么+1，要么-1）。
                         *
                         * + 10：添加这个值是为了确保最终的结果始终是非负的。这是必要的，
                         * 因为Java中的模运算符 % 返回除法后的余数，如果被除数为负数，余数可能为负数。添加10确保即使步骤2和3中的减法和加法结果为负数，
                         * 最终的结果也是非负的。
                         *
                         * % 10：最后，应用模运算符确保结果在0到9的范围内。这样处理了从9到0或从0到9的循环。
                         */
                        int digit = (currentArray[j] - '0' + k + 10) % 10;
                        currentArray[j] = (char) (digit + '0');
                        String neighbor = new String(currentArray);

                        if (!deadSet.contains(neighbor) && !visited.contains(neighbor)) {
                            queue.offer(neighbor);
                            visited.add(neighbor);
                        }
                    }
                }
            }

            steps++;
        }

        return -1; // 无法解锁
    }
}
