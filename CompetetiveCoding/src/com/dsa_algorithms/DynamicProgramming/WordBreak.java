package com.dsa_algorithms.DynamicProgramming;

public class WordBreak {
    public static Boolean wordBreak(String[] arr, int n, String target) {
        // Write your code here.
        int i, j, m = target.length();
        boolean[] dp = new boolean[m+1];
        dp[0] = true;

        for(i=1; i <=m; i++){
            for(j=1; j<=n; j++){
                if (i >= arr[j-1].length() && arr[j-1].equals(target.substring(i-arr[j-1].length(), i)))
                    dp[i] = dp[i-arr[j-1].length()];
            }
        }
        return dp[m];
    }
}
