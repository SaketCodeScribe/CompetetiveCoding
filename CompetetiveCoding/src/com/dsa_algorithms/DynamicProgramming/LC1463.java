package com.dsa_algorithms.DynamicProgramming;

import java.util.Arrays;

public class LC1463 {
    public int cherryPickup(int[][] grid) {
        int i, j, k, m = grid.length, n = grid[0].length, cherries = 0;
        int[][] prev = new int[n][n], dp;
        int[] yDirs = new int[]{-1,0,1};

        for(int[] row:prev) Arrays.fill(row, -1);
        prev[0][n-1] = grid[0][0] + (n > 1 ? grid[0][n-1] : 0);

        for(i=1; i<m; i++) {
            dp = new int[n][n];
            for(int[] row:dp) Arrays.fill(row, -1);

            for(j=0; j<= Math.min(i, n-1); j++) {
                for(k = n - 1 - Math.min(i, n-1); k<n; k++) {
                    for(int yDir1:yDirs) {
                        for(int yDir2:yDirs) {
                            int y1 = j + yDir1, y2 = k + yDir2;
                            if (y1 >= 0 && y2 >= 0 && y1 < n && y2 < n && prev[y1][y2] >= 0) {
                                dp[j][k] = Math.max(dp[j][k], prev[y1][y2] + grid[i][j] + (j != k ? grid[i][k] : 0));
                            }
                        }
                    }
                    if (i == m-1) cherries = Math.max(cherries, dp[j][k]);
                }
            }
            prev = dp;
        }
        return cherries;
    }
}
