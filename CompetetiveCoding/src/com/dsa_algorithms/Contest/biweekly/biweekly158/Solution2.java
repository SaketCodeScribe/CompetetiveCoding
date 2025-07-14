package com.dsa_algorithms.Contest.biweekly.biweekly158;

import java.util.Arrays;

public class Solution2 {
    public long maximumProfit(int[] prices, int k) {
        int n = prices.length;

        Long[][][] dp = new Long[n][3][k+1];
        solveForProfit(prices, n, k, 0, 0, k, dp);
        long max = 0;
        for(int i=1; i<=k; i++){
            max = Math.max(dp[0][0][i] != null ? dp[0][0][i] : -1, max);
        }
        return max;
    }
    private long solveForProfit(int[] prices, int n, int k, int i, int transactionType, int remTrans, Long[][][] dp) {
        if (i >= n || remTrans == 0){
            return transactionType == 2 ? Integer.MIN_VALUE : 0;
        }

        if (dp[i][transactionType][remTrans] != null){
            return dp[i][transactionType][remTrans];
        }
        long result =solveForProfit(prices, n, k, i+1, transactionType, remTrans, dp);
        if (transactionType == 0){
            result = Math.max(result, solveForProfit(prices, n, k, i+1, 1, remTrans, dp)-prices[i]);
            result = Math.max(result, solveForProfit(prices, n, k, i+1, 2, remTrans, dp)+prices[i]);
        }
        else if (transactionType == 1){
            result = Math.max(result, solveForProfit(prices, n, k, i+1, 0, remTrans-1, dp)+prices[i]);
        }
        else if (transactionType == 2){
            result = Math.max(result, solveForProfit(prices, n, k, i+1, 0, remTrans-1, dp)-prices[i]);
        }
        return  dp[i][transactionType][remTrans] = result;
    }
}
