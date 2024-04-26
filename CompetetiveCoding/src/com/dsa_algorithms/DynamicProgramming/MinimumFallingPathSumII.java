package com.dsa_algorithms.DynamicProgramming;

public class MinimumFallingPathSumII {

    public int minFallingPathSum(int[][] grid) {
        int i, j, n = grid.length, min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE, mi1=-1, mi2=-1;
        int[][] dp = new int[n][n];

        for(j=0; j<n; j++){
            dp[0][j] = grid[0][j];
            if (grid[0][j] < min1){
                min2 = min1;
                mi2 = mi1;
                min1 = grid[0][j];
                mi1 = j;
            }
            else if (grid[0][j] < min2){
                min2 = grid[0][j];
                mi2 = j;
            }
        }
        for(i=1; i<n; i++){
            for(j=0; j<n; j++){
                if (mi1 != j)
                    dp[i][j] = min1+grid[i][j];
                else
                    dp[i][j] = min2+grid[i][j];
            }
            min1 = min2 = Integer.MAX_VALUE;
            mi1 = mi2 = -1;
            for(j=0; j<n; j++){
                if (dp[i][j] < min1){
                    min2 = min1;
                    mi2 = mi1;
                    min1 = dp[i][j];
                    mi1 = j;
                }
                else if (dp[i][j] < min2){
                    min2 = dp[i][j];
                    mi2 = j;
                }
            }
        }
        return min1;
    }
}
