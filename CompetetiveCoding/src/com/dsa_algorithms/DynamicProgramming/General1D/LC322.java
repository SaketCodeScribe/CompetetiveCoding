package com.dsa_algorithms.DynamicProgramming.General1D;

import java.util.Arrays;

public class LC322 {
    public int coinChange(int[] coins, int amount) {
        int i, j, n = coins.length;
        int[] dp = new int[amount+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for(i=0; i<amount; i++){
            if (dp[i] == Integer.MAX_VALUE) continue;
            for(j=0; j<n; j++){
                if (i+(long)coins[j] <= amount){
                    dp[i+coins[j]] = Math.min(dp[i+coins[j]], dp[i]+1);
                }
            }
        }
        return dp[amount] < Integer.MAX_VALUE ? dp[amount] : -1;
    }
}
