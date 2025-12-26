package com.dsa_algorithms.DynamicProgramming.GridDP;

public class LC63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length, i, j;
        int[] curr = new int[n];
        curr[0] = 1;

        for(i=0; i<m; i++){
            curr[0] = obstacleGrid[i][0] == 1 ? Integer.MIN_VALUE : curr[0];
            for(j=1; j<n; j++){
                curr[j] = obstacleGrid[i][j] == 1 ? Integer.MIN_VALUE :
                        (curr[j] >= 0 && curr[j-1] >= 0 ? curr[j] + curr[j-1] : Math.max(curr[j], curr[j-1]));
            }
        }
        return Math.max(curr[n-1], 0);
    }
}
