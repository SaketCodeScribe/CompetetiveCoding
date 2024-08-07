package com.dsa_algorithms.DynamicProgramming.Edit_Distance;

public class RegularExpression {
    public boolean isMatch(String s, String p) {
        int i, j, m = s.length(), n = p.length();
        boolean[][] dp = new boolean[m+1][n+1];

        dp[0][0] = true;
        for(i=1; i<=n; i++){
            if (p.charAt(i-1) == '*')
                dp[0][i] = i > 1 ? dp[0][i-2] : true;
        }
        for(i=1; i<=m; i++){
            for(j=1; j<=n; j++){
                if (s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '.')
                    dp[i][j] = dp[i-1][j-1];
                else if (p.charAt(j-1) == '*')
                    dp[i][j] = (j > 1 && (s.charAt(i-1) == p.charAt(j-2) || p.charAt(j-2) == '.') ? dp[i-1][j] : false) || dp[i][j-2];
            }
        }
        return dp[m][n];
    }
}
