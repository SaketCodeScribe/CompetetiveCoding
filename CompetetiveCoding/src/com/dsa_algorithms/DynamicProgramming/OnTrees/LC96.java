package com.dsa_algorithms.DynamicProgramming.OnTrees;

public class LC96 {
    public int numTrees(int n) {
        int i, j;
        int[] dp = new int[n+1];
        dp[1] = dp[0] = 1;

        for(i=2; i<=n; i++){
            for(j=1; j<=i; j++){
                dp[i] += dp[j-1] * dp[i-j];
            }
        }
        return dp[n];
    }
}
