package com.dsa_algorithms.DynamicProgramming.GridDP;

import java.util.Arrays;

public class LC64 {
    public int minPathSum(int[][] grid) {
        int i, j, m = grid.length, n = grid[0].length;
        int[] curr = new int[n];
        Arrays.fill(curr, Integer.MAX_VALUE);
        curr[0] = 0;

        for(i=0; i<m; i++){
            for(j=0; j<n; j++){
                curr[j] = Math.min(j > 0 ? curr[j-1] : curr[j], curr[j])+grid[i][j];
            }
        }
        return curr[n-1];
    }
}
