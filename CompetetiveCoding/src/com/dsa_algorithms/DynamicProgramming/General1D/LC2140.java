package com.dsa_algorithms.DynamicProgramming.General1D;

public class LC2140 {
    public long mostPoints(int[][] questions) {
        int i, j, n = questions.length;
        long[] dp = new long[n];

        dp[n-1] = questions[n-1][0];

        for(i=n-2; i>=0; i--){
            int skip = i+questions[i][1]+1;
            dp[i] = questions[i][0];
            if (skip < n){
                dp[i] += dp[skip];
            }
            dp[i] = Math.max(dp[i], dp[i+1]);
        }
        return dp[0];
    }
}
