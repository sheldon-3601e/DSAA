package com.sheldon.basic;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sheldon
 * 797. All Paths From Source to Target
 * https://leetcode.com/problems/all-paths-from-source-to-target/
 */

class allPathsSourceTarget_DFS {

    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        path.add(0);
        dfs(graph, 0);
        return result;
    }

    public void dfs(int[][] graph, int x) {
        if (x == graph.length - 1) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < graph[x].length; i++) {
            path.add(graph[x][i]);
            dfs(graph, graph[x][i]);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[][] graph = {{1, 2}, {3}, {3}, {}};
        allPathsSourceTarget_DFS allPathsSourceTarget = new allPathsSourceTarget_DFS();
        List<List<Integer>> result = allPathsSourceTarget.allPathsSourceTarget(graph);
        System.out.println(result);
    }

}