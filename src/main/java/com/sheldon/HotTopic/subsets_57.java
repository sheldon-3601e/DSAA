package com.sheldon.HotTopic;

import java.util.ArrayList;
import java.util.List;

class subsets_57 {

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        traversal(nums, 0);
        return res;
    }

    void traversal(int[] nums, int startIndex) {
        // 将每个节点的值都记录下来
        res.add(new ArrayList<>(path));
        // 递归终止条件
        if (startIndex >= nums.length) {
            return;
        }

        for (int i = startIndex; i < nums.length; i++) {
            path.add(nums[i]);
            traversal(nums, i + 1);
            path.remove(path.size() - 1);
        }
    }
}