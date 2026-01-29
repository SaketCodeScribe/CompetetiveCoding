package com.dsa_algorithms.DynamicProgramming.Knapsack;

import java.util.Arrays;

public class LC518 {
    public int change(int amount, int[] coins) {
        int i, j, n = coins.length;
        int[] dp = new int[amount+1];
        Arrays.sort(coins);
        dp[0] = 1;

        for(i=0; i<n; i++){
            for(j=coins[i]; j<=amount; j++){
                dp[j] += dp[j-coins[i]];
            }
        }
        return dp[amount];
    }
}
