package com.dsa_algorithms.DynamicProgramming.LongestCommonSubsequence;

public class LC1143 {
    public int longestCommonSubsequence(String text1, String text2) {
        int i, j, m = text1.length(), n = text2.length(), lcs = 0;
        int[][] dp = new int[m+1][n+1];

        for(i=1; i<=m; i++){
            char ch = text1.charAt(i-1);
            for(j=1; j<=n; j++){
                if (ch == text2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
                lcs = Math.max(lcs, dp[i][j]);
            }
        }
        return lcs;
    }
}
