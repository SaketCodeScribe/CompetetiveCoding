package com.dsa_algorithms.DynamicProgramming;

public class CountSubmatriceswithTopLeftElementandSumLessThank {
    public int countSubmatrices(int[][] grid, int k) {
        int i, j, m = grid.length, n = grid[0].length, ans = 0;
        int[][] dp = new int[m+1][n+1];
        if (grid[0][0] > k)
            return ans;
        for(i=1; i<=m; i++){
            for(j=1; j<=n; j++){
                dp[i][j] = dp[i][j-1]+dp[i-1][j]+grid[i-1][j-1]-dp[i-1][j-1];
                if (dp[i][j] <= k)
                    ans++;
            }
        }
        return ans;
    }
}
