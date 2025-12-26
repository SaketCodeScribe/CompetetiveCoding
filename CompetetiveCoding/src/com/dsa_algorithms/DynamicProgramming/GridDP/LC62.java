package com.dsa_algorithms.DynamicProgramming.GridDP;

public class LC62 {
    public int uniquePaths(int m, int n) {
        int i, j;
        int[] curr = new int[n];
        curr[0] = 1;

        for(i=0; i<m; i++){
            for(j=1; j<n; j++){
                curr[j] += curr[j-1];
            }
        }
        return curr[n-1];
    }
}
