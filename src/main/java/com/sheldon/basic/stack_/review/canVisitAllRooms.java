package com.sheldon.basic.stack_.review;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 有 n 个房间，房间按从 0 到 n - 1 编号。最初，除 0 号房间外的其余所有房间都被锁住。你的目标是进入所有的房间。然而，你不能在没有获得钥匙的时候进入锁住的房间。
 *
 * 当你进入一个房间，你可能会在里面找到一套不同的钥匙，每把钥匙上都有对应的房间号，即表示钥匙可以打开的房间。你可以拿上所有钥匙去解锁其他房间。
 *
 * 给你一个数组 rooms 其中 rooms[i] 是你进入 i 号房间可以获得的钥匙集合。如果能进入 所有 房间返回 true，否则返回 false。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：rooms = [[1],[2],[3],[]]
 * 输出：true
 * 解释：
 * 我们从 0 号房间开始，拿到钥匙 1。
 * 之后我们去 1 号房间，拿到钥匙 2。
 * 然后我们去 2 号房间，拿到钥匙 3。
 * 最后我们去了 3 号房间。
 * 由于我们能够进入每个房间，我们返回 true。
 *
 * 链接：https://leetcode.cn/leetbook/read/queue-stack/gle1r/
 */

public class canVisitAllRooms {
    public boolean canVisitAllRooms01(List<List<Integer>> rooms) {
        int n = rooms.size();
        // 记录已经访问过的房间
        Set visited = new HashSet();
        dfs(rooms, 0, visited);
        return visited.size() == n;
    }

    public static void dfs(List<List<Integer>> rooms, int x, Set<Integer> visited) {
        visited.add(x);
        for (int i : rooms.get(x)) {
            if (!visited.contains(i)) {
                dfs(rooms, i, visited);
            }
        }
    }
}