package com.dsa_algorithms.DynamicProgramming;

public class UglyNumberII {
    public int nthUglyNumber(int n) {
        int[] dp = new int[n+1];
        dp[1] = 1;
        int t2 = 1, t3 = 1, t5 = 1;
        for(int i=2; i<=n; i++){
            dp[i] = Math.min(dp[t2]*2, Math.min(dp[t3]*3, dp[t5]*5));
            if (dp[i] == dp[t2]*2)
                t2++;
            if (dp[i] == dp[t3]*3)
                t3++;
            if (dp[i] == dp[t5]*5)
                t5++;
        }
        return dp[n];
    }
}
