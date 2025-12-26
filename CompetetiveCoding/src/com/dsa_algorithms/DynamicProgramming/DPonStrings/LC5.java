package com.dsa_algorithms.DynamicProgramming.DPonStrings;

public class LC5 {
    public String longestPalindrome(String s) {
        int i, j, n = s.length(), begin = 0, end = 1;
        boolean[][] isPalindrome = new boolean[n][n];

        for(i=0; i<n; i++){
            for(j=i; j>=0; j--){
                if (i == j){
                    isPalindrome[j][i] = true;
                }
                else if (i == j+1){
                    isPalindrome[j][i] = s.charAt(j) == s.charAt(i);
                }
                else{
                    isPalindrome[j][i] = s.charAt(j) == s.charAt(i) && isPalindrome[j+1][i-1];
                }
                if (isPalindrome[j][i] && end-begin < i-j+1){
                    end = i+1;
                    begin = j;
                }
            }
        }
        return s.substring(begin, end);
    }
}
