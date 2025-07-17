package com.dsa_algorithms.practice;

public class L3563 {
    public String lexicographicallySmallestString(String s) {
        int n = s.length();
        Integer[] dp = new Integer[n];

        helper(s, n, 0, dp);
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while(i < n){
            if (dp[i] == null || dp[i] == 0){
                sb.append(s.charAt(i++));
            }
            else{
                i += dp[i];
            }
        }
        return sb.toString();
    }
    private int helper(String s, int n, int i, Integer[] dp){
        if (i >= n){
            return 0;
        }
        if (dp[i] != null){
            return dp[i];
        }
        int res = 0, j;
        for(j = i; j<n-1; j++)
        if (Math.abs(s.charAt(j)-s.charAt(j+1)) == 1 && (j+2 >= n || s.charAt(j+2) <= s.charAt(i))){
            helper(s, n, j+3, dp);
        }
        else{
            helper(s, n, i+2, dp);
        }
        return dp[i] = j-i+1;
    }
}
