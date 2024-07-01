package com.dsa_algorithms.String;

public class LongestPalindromicSubstring {
    String ans;
    public String longestPalindrome(String s) {
        int i = 0, n = s.length();
        ans = "";

        while(i < n){
            lengthOfPalindrome(i,i+1,n,s);
            lengthOfPalindrome(i-1,i+1, n,s);
            i++;
        }
        return ans;
    }
    public void lengthOfPalindrome(int i, int j, int n, String s){
        while(i >=0 && j < n && s.charAt(i) == s.charAt(j)){
            i--;
            j++;
        }
        if (ans.length() < j-i-1)
            ans = s.substring(i+1, j);

    }
}
