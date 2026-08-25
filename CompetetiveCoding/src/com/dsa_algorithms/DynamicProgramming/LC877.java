package com.dsa_algorithms.DynamicProgramming;

public class LC877 {
    public boolean stoneGame(int[] piles) {
        int n = piles.length, i, j;
        Integer[][] dp = new Integer[n][n];

        stoneGame(piles, dp, 0, n-1);
        return dp[0][n-1] > 0;
    }
    private int stoneGame(int[] piles, Integer[][] dp, int i, int j) {
        if (i > j) return 0;
        if (dp[i][j] != null) return dp[i][j];
        int result, n = piles.length, len = n - (j-i+1);
        int party = (n - len)%2;
        if (party == 0) {
            result = Math.max(stoneGame(piles, dp, i+1, j)+piles[i], stoneGame(piles, dp, i, j-1)+piles[j]);
        } else {
            result = Math.min(stoneGame(piles, dp, i+1, j)-piles[i], stoneGame(piles, dp, i, j-1)-piles[j]);
        }
        return dp[i][j] = result;
    }
}
