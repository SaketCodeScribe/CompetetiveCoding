package com.dsa_algorithms.BackTracking;

import java.util.ArrayList;
import java.util.List;

public class LC131 {
    public List<List<String>> partition(String s) {
        int i, j, n = s.length();
        List<List<String>> ans = new ArrayList<>();

        boolean[][] dp = new boolean[n][n];

        for(i=0; i<n; i++) {
            for(j=i; j>=0; j--) {
                char ch1 = s.charAt(j), ch2 = s.charAt(i);
                if (i == j) dp[j][i] = true;
                else if (j == i-1) dp[j][i] = ch1 == ch2;
                else dp[j][i] = ch1 == ch2 && dp[j+1][i-1];
            }
        }
        collectPallindromePartition(s, dp, 0, n, ans, new ArrayList<>());
        return ans;
    }
    private void collectPallindromePartition(String s, boolean[][] dp, int begin, int n, List<List<String>> ans, List<String> aux) {
        if (begin >= n) {
            ans.add(new ArrayList<>(aux));
            return;
        }

        for(int i=begin; i<n; i++) {
            if (dp[begin][i]) {
                aux.add(s.substring(begin, i+1));
                collectPallindromePartition(s, dp, i+1, n, ans, aux);
                aux.remove(aux.size()-1);
            }
        }
    }
}
