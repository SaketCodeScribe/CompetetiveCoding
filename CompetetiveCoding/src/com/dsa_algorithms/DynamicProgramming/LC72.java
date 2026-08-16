package com.dsa_algorithms.DynamicProgramming;

public class LC72 {
    public int minDistance(String word1, String word2) {
        int m = word2.length(), n = word1.length(), i, j;
        if (m < n) return minDistance(word2, word1);

        int[] curr = new int[n+1];

        for(i=0; i<=m; i++) {
            int up = 0, diag = 0;
            for(j=0; j<=n; j++) {
                diag = up;
                up = curr[j];
                if (i == 0 || j == 0) curr[j] = j + i;
                else if (word2.charAt(i-1) == word1.charAt(j-1)) curr[j] = diag;
                else curr[j] = Math.min(curr[j-1], Math.min(diag, up)) + 1;
            }
        }
        return curr[n];
    }
}
