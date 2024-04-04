package com.dsa_algorithms.DynamicProgramming;

import java.util.Arrays;

public class FindtheSumofthePowerofAllSubsequences {
    private static final int MOD = (int)Math.pow(10,9)+7;
    long[] pow;
    public int sumOfPower(int[] nums, int k) {
        int n = nums.length;
        long[][][] dp = new long[n][k+1][n+1];
        Arrays.stream(dp).forEach(arr -> Arrays.stream(arr).forEach(v -> Arrays.fill(v, -1)));
        Arrays.sort(nums);
        pow = new long[n+1];
        pow[0] = 1;
        for(int i=1; i<=n; i++)
            pow[i] = (pow[i-1]*2)%MOD;
        return (int)findPower(0,0,n,k,nums,dp);
    }
    public long findPower(int i, int cnt, int n, int k, int[] nums, long[][][] dp){
        if (k == 0)
            return pow[n-cnt];
        if (i >= n || k < 0 || nums[i] > k)
            return 0;
        if (dp[i][k][cnt] != -1)
            return dp[i][k][cnt];
        return dp[i][k][cnt] = (findPower(i+1, cnt+1, n, k-nums[i], nums, dp)%MOD + findPower(i+1, cnt, n, k, nums, dp)%MOD)%MOD;
    }
}
