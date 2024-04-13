package com.dsa_algorithms.DynamicProgramming;

import java.util.*;
public class UniqueBinarySearchTrees1 {
    long[][] dp;
    public int numTrees(int n) {
        dp = new long[n][n];
        Arrays.stream(dp).forEach(arr -> Arrays.fill(arr,-1));
        return (int)generateTrees(0, n-1);
    }
    public long generateTrees(int l, int r) {
        if (l == r)
            return 1;
        if (l > r)
            return 0;
        if (dp[l][r] != -1)
            return dp[l][r];
        int cnt = 0;
        for(int i=l; i<=r; i++){
            long left = generateTrees(l, i-1);
            long right = generateTrees(i+1,r);
            cnt += (left > 0 && right > 0) ? left*right : (left > 0 ? left : (right > 0 ? right : 0));
        }
        return dp[l][r] = cnt;
    }
}
