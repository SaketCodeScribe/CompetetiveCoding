package com.dsa_algorithms.DynamicProgramming.NoOfWays;

import java.util.Arrays;

public class LC3193 {
    private static final int MOD = 1_000_000_007;

    public int numberOfPermutations(int n, int[][] requirements) {
        int m = 0;
        int[][] dp = new int[n+1][n*(n-1)/2+1];

        Arrays.sort(requirements, (a, b) -> Integer.compare(a[0], b[0]));
        compute(n, dp, requirements);
        int ans = 0;
        for(int j=0; j<=n*(n-1)/2; j++){
            ans = (ans + dp[n][j]) % MOD;
        }
        return ans;
    }
    private void compute(int n, int[][] dp, int[][] arr){
        int i, j, k, l = 0, cnt;
        dp[0][0] = 1;

        for(i=1; i<=n; i++){
            if (l < arr.length && arr[l][0] == i-1){
                cnt = 0;
                for(k=1; k<=Math.min(i, arr[l][1]+1); k++){
                    cnt = (cnt + dp[i-1][arr[l][1]-k+1]) % MOD;
                }
                dp[i][arr[l++][1]] = cnt;
            }
            else{
                for(j=0; j<=i*(i-1)/2; j++){
                    cnt = j+1 <= i ? dp[i-1][j] : (dp[i-1][j] - dp[i-1][j-i] + MOD) % MOD;
                    dp[i][j] = (cnt + (j > 0 ? dp[i][j-1] : 0)) % MOD;
                }
            }
        }
    }
}
