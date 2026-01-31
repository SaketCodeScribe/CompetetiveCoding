package com.dsa_algorithms.DynamicProgramming.General1D;

public class LC2466 {
    private static final int MOD = 1_000_000_007;
    public int countGoodStrings(int low, int high, int zero, int one) {
        int[] counts = new int[]{zero, one};

        return (countSubstrings(high, counts) - countSubstrings(low-1, counts) + MOD) % MOD;
    }
    private int countSubstrings(int n, int[] counts){
        if (n <= 0){
            return 0;
        }
        int i, count = 0;
        int[] dp = new int[n+1];
        dp[0] = 1;

        for(i=1; i<=n; i++){
            for (int cnt:counts){
                if (cnt > i) continue;
                dp[i] = (dp[i] + dp[i-cnt])%MOD;
            }
            count = (count + dp[i]) %MOD;
        }
        return count;
    }
}
