package com.dsa_algorithms.practice;

public class L1997 {
    private final int MOD = 1_000_000_007;
    public int firstDayBeenInAllRooms(int[] nextVisit) {
        int i, n = nextVisit.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 1;
        dp[0][1] = 2;

        for(i=1; i<n; i++){
            dp[i][0] = dp[i-1][1]+1;
            dp[i][1] = dp[i][0]+1;
            if (nextVisit[i] < i){
                dp[i][1] = ((dp[i][1] + dp[i-1][1])%MOD - (nextVisit[i] > 0 ? dp[nextVisit[i]][0]-1 : 0) + MOD)%MOD;
            }
        }
        return (int)(dp[n-1][0]-1+MOD)%MOD;
    }
}
