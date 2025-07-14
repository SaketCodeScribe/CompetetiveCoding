package com.dsa_algorithms.practice;

public class L3339 {
    private final int MOD = 1_000_000_007;
    private int odd = 0, even = 0;
    public static void main(String[] args) {

    }
    public int countOfArrays(int n, int m, int k) {
        odd = (m+1)>>1;
        even = m>>1;
        Long[][][] dp = new Long[n][k+1][2];
        return (int)(findTotCount(0, 1, k, n, dp)%MOD);
    }
    private Long findTotCount(int i, int state, int k, int n, Long[][][] dp){
        if (i >= n){
            return k > 0 ? 0L : 1L;
        }
        if (dp[i][k][state] != null){
            return dp[i][k][state];
        }
        long result = odd*findTotCount(i+1, 1, k, n, dp);
        if (k == 0){
            if (state == 1) {
                result += even*findTotCount(i+1, 0, k, n, dp)%MOD;
            }
        }
        else{
            if (state == 0){
                result += even*findTotCount(i+1, 0, k-1, n, dp)%MOD;
            }
            else{
                result += even*findTotCount(i+1, 0, k, n, dp)%MOD;
            }
        }
        return dp[i][k][state] = result;
    }
}
