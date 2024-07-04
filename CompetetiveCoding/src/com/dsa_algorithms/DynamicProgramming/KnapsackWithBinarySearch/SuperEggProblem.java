package com.dsa_algorithms.DynamicProgramming.KnapsackWithBinarySearch;

public class SuperEggProblem {
    int[][] dp;
    public int superEggDrop(int k, int n) {
        dp = new int[n+1][k+1];
        return findMoves(n, k);
    }
    public int findMoves(int n, int e) {
        if (e == 1)
            return n;
        if (n < 2)
            return n;
        if (dp[n][e] > 0)
            return dp[n][e];
        int low = 1, high = n;

        while(low+1 < high){
            int mid = (low+high) >> 1;
            int t1 = findMoves(mid-1, e-1);
            int t2 = findMoves(n-mid, e);
            if (t1 < t2)
                low = mid;
            else
                high = mid;
        }
        return dp[n][e] = 1+Math.min(Math.max(findMoves(low-1, e-1), findMoves(n-low, e)),
                Math.max(findMoves(high-1, e-1), findMoves(n-high, e)));
    }
}
