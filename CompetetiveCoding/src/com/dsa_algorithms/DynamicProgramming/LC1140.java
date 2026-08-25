package com.dsa_algorithms.DynamicProgramming;

public class LC1140 {
    public int stoneGameII(int[] piles) {
        int n = piles.length;
        Integer[][] dp = new Integer[n][n + 1];
        int[] suffix = new int[n + 1];

        for (int i = n - 1; i >= 0; i--) {
            suffix[i] = suffix[i + 1] + piles[i];
        }

        return stoneGame(piles, dp, suffix, n, 0, 1);
    }

    private int stoneGame(int[] piles, Integer[][] dp, int[] suffix, int n, int i, int m) {
        if (i >= n) return 0;
        if (dp[i][m] != null) return dp[i][m];

        int res = 0;
        for (int k = 1; k <= Math.min(2 * m, n) && i + k <= n; k++) {
            res = Math.max(res, suffix[i] - stoneGame(piles, dp, suffix, n, i + k, Math.max(m, k)));
        }
        return dp[i][m] = res;
    }
}
