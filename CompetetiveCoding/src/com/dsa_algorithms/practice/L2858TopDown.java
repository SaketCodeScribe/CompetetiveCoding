package com.dsa_algorithms.practice;

public class L2858TopDown {
    public int waysToReachTarget(int target, int[][] types) {
        int n = types.length;
        Integer[][] dp = new Integer[n][target+1];

        noOfWays(types, n, 0, target, dp);
        return dp[0][target];
    }
    private int noOfWays(int[][] types, int n, int i, int target, Integer[][] dp){
        if (target == 0){
            return 1;
        }
        if (i >= n){
            return 0;
        }
        if (dp[i][target] != null){
            return dp[i][target];
        }
        int ways = 0;
        for(int count=0; count<=types[i][0]; i++){
            if (target <= count*types[i][1]) {
                ways += noOfWays(types, n, i + 1, target - count * types[i][1], dp);
            }
        }
        return dp[i][target] = ways;
    }
}
