package com.dsa_algorithms.DynamicProgramming;

import java.util.Arrays;

public class MaximumStrengthofKDisjointSubarrays {
    long[][] dp;
    private static final long MOD = -(long)Math.pow(10,16);
    public long maximumStrength(int[] nums, int k) {
        int i, n = nums.length;
        long[] pre = new long[n+1];
        dp = new long[n+1][2*k+1];
        Arrays.stream(dp).forEach(arr -> Arrays.fill(arr, MOD));
        for(i=1; i<=n; i++)
            pre[i] = pre[i-1]+(long)nums[i-1];
        return maximumStrength(0, n+1, 2*k, pre);
    }
    public long maximumStrength(int i, int n, int k, long[] pre){
        if (i >= n || k < 0)
            return MOD;
        if (k == 0)
            return 0;
        if (dp[i][k] != MOD)
            return dp[i][k];
        dp[i][k] = maximumStrength(i+1, n, k, pre);
        long rK = (k+1)/2;
        long sign = rK%2 == 0 ? -1 : 1;
        long curr;
        if (k%2 == 0)
            curr = -sign*pre[i]*rK+maximumStrength(i+1, n, k-1, pre);
        else
            curr = sign*pre[i]*rK+maximumStrength(i, n, k-1, pre);
        return dp[i][k] = Math.max(dp[i][k], curr);
    }
}
