package com.dsa_algorithms.DynamicProgramming.DPonStrings;

import java.util.List;

public class LC139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        int i, j, n = s.length();
        boolean[] dp = new boolean[n+1];
        dp[0] = true;

        for(i=1; i<=n; i++){
            for(String word:wordDict){
                if (i >= word.length() && s.startsWith(word, i-word.length())){
                    dp[i] |= dp[i-word.length()];
                }
            }
        }
        return dp[n];
    }
}
