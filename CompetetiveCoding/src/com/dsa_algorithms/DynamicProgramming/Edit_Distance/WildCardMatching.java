package com.dsa_algorithms.DynamicProgramming.Edit_Distance;

public class WildCardMatching {
    public boolean isMatch(String s, String p) {
        int i, j, m = s.length(), n = p.length();
        boolean[] curr, prev = new boolean[n+1];
        prev[0] = true;

        for(i=1; i<=n; i++){
            if (p.charAt(i-1) != '*')
                break;
            prev[i] = true;
        }
        for(i=1; i<=m; i++){
            curr = new boolean[n+1];
            for(j=1; j<=n; j++){
                if (s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '?')
                    curr[j] = prev[j-1];
                else if (p.charAt(j-1) == '*')
                    curr[j] = prev[j] || curr[j-1];
            }
            prev = curr;
        }
        return prev[n];
    }
}
