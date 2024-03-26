package com.dsa_algorithms.String;

public class ExistenceofaSubstringinaStringandItsReverse {
    public boolean isSubstringPresent(String s) {
        int i, j, m = s.length();
        String p = new StringBuilder(s).reverse().toString();
        int[][] dp = new int[m+1][m+1];

        for(i=1; i<=m; i++){
            for(j=1; j<=m; j++){
                if(s.charAt(i-1) == p.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1]+1;
                if (dp[i][j] == 2)
                    return true;
            }
        }
        return false;
    }
}
