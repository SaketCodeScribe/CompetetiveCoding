package com.dsa_algorithms.practice;

public class L3573 {
    public long maximumProfit(int[] prices, int k) {
        int n = prices.length;
        Long[][][][] dp = new Long[n][k+1][2][2];

        return maximumProfit(prices, n, 0, k, 0, 1, dp);
    }

    private long maximumProfit(int[] prices, int n, int i, int k, int transactionType, int type, Long[][][][] dp) {
        if (i >= n || k == 0){
            return (transactionType == 0 && type == 0) || (transactionType == 1 && type == 1) ?
                            Integer.MIN_VALUE : 0;
        }
        if (dp[i][k][transactionType][type] != null){
            return dp[i][k][transactionType][type];
        }
        long profit = 0;
        if (transactionType == 0){
            if (type == 0){
                profit = maximumProfit(prices, n, i+1, k-1, transactionType, 1, dp) + prices[i];
            }
            else{
                profit = Math.max(maximumProfit(prices, n, i+1, k, transactionType, 0, dp) - prices[i],
                                    maximumProfit(prices, n, i+1, k, 1, 1, dp) + prices[i]);
            }
        }
        else{
            if (type == 1){
                profit = maximumProfit(prices, n, i+1, k-1, transactionType, 0, dp) - prices[i];
            }
            else{
                profit = Math.max(maximumProfit(prices, n, i+1, k, transactionType, 1, dp) + prices[i],
                        maximumProfit(prices, n, i+1, k, 0, 0, dp) - prices[i]);
            }
        }
        profit = Math.max(profit,
                    maximumProfit(prices, n, i+1, k, transactionType, type, dp));
        return dp[i][k][transactionType][type] = profit;
    }

}
