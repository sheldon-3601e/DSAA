package com.sheldon.HotTopic;

import java.util.*;

/**
 * Created by sheldon on 18-7-25.
 * 207. 课程表
 * 现在你总共有 n 门课需要选，记为 0 到 n-1。
 * 在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们: [0,1]
 * 给定课程总量以及它们的先决条件，判断是否可能完成所有课程的学习？
 * https://leetcode.cn/problems/course-schedule
 */

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        // 定义入度表
        int[] indegree = new int[numCourses];
        // 定义邻接表
        // k - 课程编号 v - 依赖该课程的课程编号
        Map<Integer, List<Integer>> map = new HashMap<>();
        // 队列，存放入度为0的课程编号
        Queue<Integer> queue = new LinkedList<>();

        // 初始化邻接表和入度表
        for (int[] p : prerequisites) {
            int curCourse = p[0];
            int preCourse = p[1];

            // 初始化入度数组
            indegree[curCourse]++;
            // 初始化邻接表
            map.putIfAbsent(preCourse, new ArrayList<>());
            map.get(preCourse).add(curCourse);
        }

        // 遍历入度数组，将入度为0的课程编号放入队列
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        // bfs
        while (!queue.isEmpty()) {
            numCourses--;
            // 获取前置课程
            Integer preCourse = queue.poll();

            // 遍历该课程的后置课程
            for (Integer curCourse : map.getOrDefault(preCourse, new ArrayList<>())) {
                // 入度减1
                indegree[curCourse]--;
                // 如果入度为0，则放入队列
                if (indegree[curCourse] == 0) {
                    queue.offer(curCourse);
                }
            }

        }
        return numCourses == 0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int numCourses = 2;
        int[][] prerequisites = {{1, 0}, {0, 1}};
        System.out.println(solution.canFinish(numCourses, prerequisites));
    }
}