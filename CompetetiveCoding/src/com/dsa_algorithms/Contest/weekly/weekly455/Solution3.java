package com.dsa_algorithms.Contest.weekly.weekly455;

public class Solution3 {
//    public String smallestPalindrome(String s, int k) {
//        int i, j, n = s.length();
//        int[] freq = new int[26];
//        char[] chars = new char[n];
//        int[][] prefix = new int[n][26];
//
//        for(i=0; i<n; i++){
//            freq[s.charAt(i)-'a']++;
//        }
//        i = 0;
//        for(j=0; j<26; j++){
//            int val = freq[j];
//            while(i < n && val > 1){
//                chars[i] = (char)('a'+j);
//                prefix[i][j]++;
//                i++;
//                val -= 2;
//            }
//        }
//
//        return recursion(chars, prefix, 0, n-1, k);
//    }
//    private String recursion(char[] chars, int[][] prefix, int left, int right, int k){
//        k--;
//        if (k == 0){
//            return String.valueOf(chars[r])
//        }
//        if (right == left){
//            return k == 0 ? String.valueOf(chars[right]) : "";
//        }
//        StringBuilder sb = new StringBuilder();
//        for(int i=right; i>= left; i--){
//            int total = 0;
//            for(int j=0; j<=26; j++){
//                total += prefix[right][j]-prefix[i][j];
//            }
//        }
//    }

    public static void main(String[] args) {

    }
}
