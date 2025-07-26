package com.dsa_algorithms.practice;

public class L1525 {
    public int numSplits(String s) {
        int i, n = s.length(), cnt = 0, ans = 0, cntLeft = 0, cntRight = 0;
        int[] left = new int[26], right = new int[26]
;
        for(i=0; i<n; i++){
            cntRight += (++right[s.charAt(i)-'a'] == 1 ? 1 : 0);
        }
        for(i=n-1; i>0; i--){
            cntLeft += (++left[s.charAt(i)-'a'] == 1 ? 1 : 0);
            cntRight -= (--right[s.charAt(i)-'a'] == 0 ? 1 : 0);
            if (cntLeft == cntRight){
                ans++;
            }
        }
        return ans;
    }
}
