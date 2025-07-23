package com.dsa_algorithms.practice;

public class L3339 {
    private final int MOD = 1_000_000_007;
    public int countOfArrays(int n, int m, int k) {
        if (n == 1 && k == 0){
            return m;
        }
        Long[][][] dp = new Long[n][k+1][2];

        return (int)countOfArrays(n, m, k, 0, 0, dp);
    }

    private long countOfArrays(int n, int m, int k, int i, int parity, Long[][][] dp) {
        int even = m/2, odd = m-even;
        if (i >= n){
            return k > 0 ? 0 : 1;
        }
        if (dp[i][k][parity] != null){
            return dp[i][k][parity];
        }
        long count = odd*countOfArrays(n, m, k, i+1, 0, dp);
        if (k == 0){
            if (parity == 0){
                count = (count + even*countOfArrays(n, m, k, i+1, 1, dp))%MOD;
            }
        }
        else {
            if (parity == 1) {
                count = (count + even * countOfArrays(n, m, k - 1, i + 1, 1, dp)) % MOD;
            } else {
                count = (count + even * countOfArrays(n, m, k, i + 1, 1, dp)) % MOD;
            }
        }
        return dp[i][k][parity] = count;
    }
}
