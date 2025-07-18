package com.dsa_algorithms.practice;

import java.util.Arrays;

public class L1278BottomUp {
    public int palindromePartition(String s, int k) {
        int i, j, p, n = s.length();
        int[][] minSwap = new int[n+1][n+1];
        int[] prev = new int[n+1], curr;
        Arrays.fill(prev, Integer.MAX_VALUE);
        prev[0] = 0;
        for(i=1; i<=n; i++){
            for(j=i-1; j>0; j--){
                if (s.charAt(j-1) == s.charAt(i-1)){
                    minSwap[j][i] = minSwap[j+1][i-1];
                }
                else{
                    minSwap[j][i] = 1+minSwap[j+1][i-1];
                }
            }
        }

        for(p=0; p<k; p++){
            curr = new int[n+1];
            Arrays.fill(curr, Integer.MAX_VALUE);
            for(i=1; i<=n; i++){
                for(j=i; j>0; j--){
                    if (prev[j-1] == Integer.MAX_VALUE){
                        continue;
                    }
                    curr[i] = Math.min(curr[i], prev[j-1] + minSwap[j][i]);
                }
            }
            prev = curr;
        }
        return prev[n];
    }
}
