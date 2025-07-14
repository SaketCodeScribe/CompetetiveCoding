package com.dsa_algorithms.practice;

import java.util.HashSet;
import java.util.Set;

/*
Given a string 's' find the no. of unique palindromic substrings.
Constraints :
s.size() <= 5000
E.g. :
s = "aacaa"
result = 5 ["a", "c", "aa", "aca", "aacaa"]
 */
public class UniquePalindromeSubstring {
    public int countSubstrings(String s) {
        int i, j, n = s.length();
        boolean[][] dp = new boolean[n][n];
        Set<String> set = new HashSet<>();

        for(i=0; i<n; i++){
            StringBuilder sb = new StringBuilder();
            for(j=i; j>=0; j--){
                sb.append(s.charAt(j));
                if (i == j){
                    dp[j][i] = true;
                }
                else{
                    dp[j][i] =( j+1 <= i-1 ? dp[j+1][i-1] : true) && s.charAt(j) == s.charAt(i);
                }
                if (dp[j][i]){
                    set.add(sb.toString());
                }
            }
        }
        return set.size();
    }

    public static void main(String[] args) {
        UniquePalindromeSubstring obj = new UniquePalindromeSubstring();
        System.out.println(obj.countSubstrings("aacaa"));
    }
}
