package com.dsa_algorithms.DynamicProgramming.General3D;

public class LC1444 {
    private static final int MOD = 1_000_000_007;
    public int ways(String[] pizza, int k) {
        int m = pizza.length, n = pizza[0].length(), p, q, r, s, cut;
        int[][][] dp = new int[m+1][n+1][k];
        int[][] apples = new int[m+1][n+1];

        initialize(m, n, pizza, apples, dp);

        for(cut=1; cut<k; cut++){
            for(p=m; p>0; p--){
                for(q=n; q>0; q--){
                    int ways = 0;
                    // horizontal cuts
                    for(r=m; r>=p+1; r--){
                        if (!hasApples(apples, p-1, q-1, r-1, n)) break;
                        ways = (ways + dp[r][q][cut-1]) % MOD;
                    }
                    // vertical cuts
                    for(r=n; r>=q; r--){
                        if (!hasApples(apples, p-1, q-1, m, r-1)) break;
                        ways = (ways + dp[p][r][cut-1]) % MOD;
                    }
                    dp[p][q][cut] = ways;
                }
            }
        }
        return dp[1][1][k-1];
    }
    private void initialize(int m , int n, String[] pizza, int[][] apples, int[][][] dp){
        int i, j;

        for(i=1; i<=m; i++){
            for(j=1; j<=n; j++){
                apples[i][j] = apples[i-1][j] + apples[i][j-1] - apples[i-1][j-1];
                apples[i][j] += pizza[i-1].charAt(j-1) == 'A' ? 1 : 0;
            }
        }
        for(i=1; i<=m; i++){
            for(j=1; j<=n; j++){
                if (hasApples(apples, i-1, j-1, m, n)){
                    dp[i][j][0] = 1;
                }
            }
        }
    }
    private boolean hasApples(int[][] apples, int r1, int c1, int r2, int c2){
        return apples[r2][c2] - apples[r1][c2] - apples[r2][c1] + apples[r1][c1] > 0;
    }
}
