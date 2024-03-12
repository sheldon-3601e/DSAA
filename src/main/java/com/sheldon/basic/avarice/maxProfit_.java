package com.sheldon.basic.avarice;

/**
 * 122. 买卖股票的最佳时机 II
 * 给你一个整数数组 prices ，其中 prices[i] 表示某支股票第 i 天的价格。
 *
 * 在每一天，你可以决定是否购买和/或出售股票。你在任何时候 最多 只能持有 一股 股票。你也可以先购买，然后在 同一天 出售。
 *
 * 返回 你能获得的 最大 利润 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：prices = [7,1,5,3,6,4]
 * 输出：7
 * 解释：在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5 - 1 = 4 。
 *      随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6 - 3 = 3 。
 *      总利润为 4 + 3 = 7 。
 *
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii
 */
class maxProfit_ {
    // 本题直观的解法是，在价格低的时候买入，价格高的时候卖出。
    // 假设我们在第一天买入，第三天卖出，即 prices[3] - prices[1]
    // 换个思路，我们在第一天买入，第二天卖出，第二天买入，第三天卖出
    // 即 prices[2] - prices[1] + prices[3] - prices[2] = prices[3] - prices[1]
    // 获得的利润其实和上面相同
    // 所以我们可以直接计算相邻两天的差值，只要是正数，就可以累加到最终的结果中
    public int maxProfit(int[] prices) {
        int result = 0;
        for (int i = 1; i < prices.length; i++) {
            // 只要差值为正数，就可以累加到结果中
            result += Math.max(0, prices[i] - prices[i - 1]);
        }
        return result;
    }
}