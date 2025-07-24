package com.dsa_algorithms.practice;

public class L935 {
    private final int MOD = 1_000_000_007;
    private final int[][] DIRS = new int[][]{{2,1},{2,-1},{-2,1},
                                            {-2,-1},{1,2},{-1,2},
                                            {1,-2},{-1,-2}};
    private final int[][] grid = new int[][]{
            {1,2,3},{4,5,6},{7,8,9},{-1,0,-1}
    };
    public int knightDialer(int n) {
        Long[][] dp = new Long[10][n+1];
        long ans = 0;
        for(int i=0; i<4; i++){
            for(int j=0; j<3; j++) {
                if (grid[i][j] != -1) {
                    ans = (ans + noOfWays(n, i, j, dp) % MOD) % MOD;
                }
            }
        }
        return (int)ans;
    }
    private long noOfWays(int n, int i, int j, Long[][] dp){
        if (n == 1){
            return 1;
        }
        int num = grid[i][j];
        if (dp[num][n] != null){
            return dp[num][n];
        }
        long count = 0;

        for(int[] dir:DIRS){
            int x = i+dir[0], y = j+dir[1];
            if (x >= 0 && y >= 0 && x < 4 && y < 3 && grid[x][y] != -1){
                count = (count + noOfWays(n-1, x, y, dp))%MOD;
            }
        }
        return dp[num][n] = count;
    }
}
