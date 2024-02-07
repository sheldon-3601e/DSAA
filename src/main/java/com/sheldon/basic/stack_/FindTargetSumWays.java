package com.sheldon.basic.stack_;

public class FindTargetSumWays {
    public int findTargetSumWays01(int[] nums, int target) {
        return dfs(nums, 0, 0, target);
    }
    
    private int dfs(int[] nums, int index, int curSum, int target) {
        // 当遍历完数组之后，进行判断
        if (index == nums.length) {
            // 如果总和等于目标值，则 return + 1
            return curSum == target ? 1 : 0;
        }
        // 进行 + 和 - 法运算
        // 并记录他们的结果值
        int add = dfs(nums, index + 1, curSum + nums[index], target);
        int subtract = dfs(nums, index + 1, curSum - nums[index], target);
        // 最后返回总数
        return add + subtract;
    }
}