package com.dsa_algorithms.DynamicProgramming;

import java.util.*;
public class FreedomTrail {
    int[][] dp;
    final int MOD = (int)1e9;
    public int findRotateSteps(String ring, String key) {
        int m = ring.length(), n = key.length();
        dp = new int[m][n];
        Arrays.stream(dp).forEach(arr -> Arrays.fill(arr, MOD));
        return findRotateSteps(0, 0, m, n, ring, key);
    }
    public int findRotateSteps(int i, int j, int m , int n, String s1, String s2){
        if (j >= n)
            return 0;
        int totalSteps = MOD;
        if (dp[i][j] != MOD)
            return dp[i][j];
        for(int k = 0; k<m; k++){
            if (s1.charAt(k) == s2.charAt(j))
                totalSteps = count(i,k,m)+1+findRotateSteps(k, j+1, m, n, s1, s2);
            dp[i][j] = Math.min(dp[i][j],totalSteps);
        }
        return dp[i][j];
    }
    public int count(int i, int j, int n){
        int step = Math.abs(j-i);
        return Math.min(step, n-step);
    }

    public static void main(String[] args) {

    }
}