package com.dsa_algorithms.DynamicProgramming.General1D;

import java.util.Arrays;

public class LC244 {
    public String shortestPalindrome(String s) {
        int n = s.length(), i, j;
        if (n == 0){
            return "";
        }
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        int lps = calcLongestPrefixSum(s+"#"+sb.toString()); // # is needed for  input liks aabba. the prefix and suffix matches by extending through the boundary

        return sb.substring(0, n-lps)+s;
    }
    private int calcLongestPrefixSum(String s){
        int i = 1, j = 0, n = s.length();
        int[] lps = new int[n];
        Arrays.fill(lps, -1);

        while(i < n){
            while (j != -1 && s.charAt(i) != s.charAt(j)){
                j = j > 0 ? lps[j-1]+1 : -1;
            }
            lps[i++] = j++;
        }
        return lps[n-1]+1;
    }
}
