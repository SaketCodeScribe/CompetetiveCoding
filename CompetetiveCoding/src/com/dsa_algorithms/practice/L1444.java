package com.dsa_algorithms.practice;

public class L1444 {
    private final int MOD = 1_000_000_007;
    public int ways(String[] pizza, int k) {
        int i, j, m = pizza.length, n = pizza[0].length();
        int[][] prefixSum = new int[m][n];
        Integer[][][] dp = new Integer[m+1][n+1][k];

        for(i=m-1; i>=0; i--){
            for(j=n-1; j>=0; j--){
                if (i == m-1 && j == n-1){
                    prefixSum[i][j] = pizza[i].charAt(j) == 'A' ? 1 : 0;
                }
                else if (i == m-1){
                    prefixSum[i][j] = (pizza[i].charAt(j) == 'A' ? 1 : 0) + prefixSum[i][j+1];
                }
                else if (j == n-1){
                    prefixSum[i][j] = (pizza[i].charAt(j) == 'A' ? 1 : 0) + prefixSum[i+1][j];
                }
                else{
                    prefixSum[i][j] = (pizza[i].charAt(j) == 'A' ? 1 : 0) + prefixSum[i+1][j]+prefixSum[i][j+1]-prefixSum[i+1][j+1];
                }
            }
        }
        return prefixSum[0][0] == 0 ? 0 : ways(prefixSum, m, n, 0, 0, k-1, dp);
    }

    private int ways(int[][] prefixSum, int m, int n, int i, int j, int k, Integer[][][] dp) {
        if (k == 0){
            return 1;
        }
        if (dp[i][j][k] != null){
            return dp[i][j][k];
        }
        int cnt = 0;

        for(int id = i+1; id < m; id++){
            if (prefixSum[id][j] > 0 && prefixSum[i][j] - prefixSum[id][j] > 0){
                cnt = (cnt + ways(prefixSum, m, n, id, j, k-1, dp))%MOD;
            }
        }
        for(int id = j+1; id < n; id++){
            if (prefixSum[i][id] > 0 && prefixSum[i][j] - prefixSum[i][id] > 0){
                cnt = (cnt + ways(prefixSum, m, n, i, id, k-1, dp))%MOD;
            }
        }
        return dp[i][j][k] = cnt;
    }
}
