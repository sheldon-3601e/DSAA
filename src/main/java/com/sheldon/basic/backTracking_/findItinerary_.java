package com.sheldon.basic.backTracking_;

import java.util.*;

/**
 * 332. 重新安排行程
 * 给你一份航线列表 tickets ，其中 tickets[i] = [fromi, toi] 表示飞机出发和降落的机场地点。请你对该行程进行重新规划排序。
 *
 * 所有这些机票都属于一个从 JFK（肯尼迪国际机场）出发的先生，所以该行程必须从 JFK 开始。如果存在多种有效的行程，请你按字典排序返回最小的行程组合。
 *
 * 例如，行程 ["JFK", "LGA"] 与 ["JFK", "LGB"] 相比就更小，排序更靠前。
 * 假定所有机票至少存在一种合理的行程。且所有的机票 必须都用一次 且 只能用一次。
 *
 * 链接：https://leetcode-cn.com/problems/reconstruct-itinerary
 */
class findItinerary_ {
    LinkedList<String> res = new LinkedList<>();
    public List<String> findItinerary(List<List<String>> tickets) {
        tickets.sort((a, b) -> a.get(1).compareTo(b.get(1)));
        res.add("JFK");
        boolean[] used = new boolean[tickets.size()];
        backtracking(tickets, used);
        return res;
    }

    boolean backtracking(List<List<String>> tickets, boolean[] used) {
        // 说明找到正确的路线
        if(res.size() == tickets.size() + 1) {
            return true;
        }

        for ( int i = 0; i < tickets.size(); i++ ) {
            // !used[i] -> 说明该路线没有被使用过
            // tickets[i].get[0].equal(res.getLast()) -> 找到 路线的起点是当前的终点 的路线
            if( !used[i] && tickets.get(i).get(0).equals(res.getLast()) ) {
                used[i] = true;
                res.addLast(tickets.get(i).get(1));
                if(backtracking(tickets, used)) {
                    return true;
                }
                res.removeLast();
                used[i] = false;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        List<List<String>> tickets = new ArrayList<>();
        List<String> t1 = new ArrayList<>();
        t1.add("MUC");
        t1.add("LHR");
        List<String> t2 = new ArrayList<>();
        t2.add("JFK");
        t2.add("MUC");
        List<String> t3 = new ArrayList<>();
        t3.add("SFO");
        t3.add("SJC");
        List<String> t4 = new ArrayList<>();
        t4.add("LHR");
        t4.add("SFO");
        tickets.add(t1);
        tickets.add(t2);
        tickets.add(t3);
        tickets.add(t4);
        findItinerary_ findItinerary = new findItinerary_();
        List<String> res = findItinerary.findItinerary(tickets);
        System.out.println(res);
    }
}