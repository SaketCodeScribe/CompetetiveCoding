package com.dsa_algorithms.DynamicProgramming.DPonStrings;

public class LC712 {
    public int minimumDeleteSum(String s, String t) {
        int i, j, m = s.length(), n = t.length();
        int[][] dp = new int[m+1][n+1];

        for(i=0; i<=m; i++){
            for(j=0; j<=n; j++){
                if (i == 0 && j == 0){
                    continue;
                }
                if (i == 0){
                    dp[i][j] = dp[i][j-1] + t.charAt(j-1);
                }
                else if (j == 0){
                    dp[i][j] = dp[i-1][j] + s.charAt(i-1);
                }
                else{
                    dp[i][j] = Math.min(dp[i][j-1] + t.charAt(j-1), dp[i-1][j] + s.charAt(i-1));
                    if (s.charAt(i-1) == t.charAt(j-1)){
                        dp[i][j] = Math.min(dp[i][j], dp[i-1][j-1]);
                    }
                }
            }
        }
        return dp[m][n];
    }
}
