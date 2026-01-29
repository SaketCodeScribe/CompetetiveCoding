package com.dsa_algorithms.DynamicProgramming.Knapsack;

public class LC279 {
    public int numSquares(int n) {
        int i, j;
        int[] dp = new int[n+1];
        dp[1] = 1;

        for(i=2; i<=n; i++){
            int cnt = Integer.MAX_VALUE;
            for(j=1; j<=(int)Math.sqrt(i); j++){
                if (i >= j*j){
                    cnt = Math.min(cnt, dp[i-j*j]+1);
                }
            }
            dp[i] = cnt;
        }
        return dp[n];
    }
}
