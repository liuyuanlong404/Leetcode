package com.rose.array;

/**
 * Created on 2021/10/16 13:39
 *
 * @author Rose
 *
 *                     买卖股票的最佳时机
 *
 * 给定一个数组 prices ，其中prices[i] 是一支给定股票第 i 天的价格。
 *
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 *
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 */
public class Test2 {

    public static void main(String[] args) {

    }

    public int maxProfit(int[] prices) {
        int total = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            //原数组中如果后一个减去前一个是正数，说明是上涨的，
            //我们就要累加，否则就不累加
            total += Math.max(prices[i + 1] - prices[i], 0);
        }
        return total;
    }
}
