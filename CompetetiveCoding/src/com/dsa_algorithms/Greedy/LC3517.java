package com.dsa_algorithms.Greedy;

public class LC3517 {
    public String smallestPalindrome(String s) {
        int[] chars = new int[26];
        int n = s.length();

        char mid = 0;
        StringBuilder sb = new StringBuilder(n/2);

        for(char ch:s.toCharArray()) {
            chars[ch-'a']++;
        }

        for(int i=0; i<26; i++) {
            if (chars[i] > 0 ) {
                for(int j=1; j<=chars[i]/2; j++) {
                    sb.append((char)(i+'a'));
                }
                if (chars[i] > 0 && chars[i] % 2 != 0) {
                    mid = (char)(i+'a');
                }
            }
        }
        String firstHalf = sb.toString();
        String secondHalf = sb.reverse().toString();
        return firstHalf + (mid != 0 ? mid : "") + secondHalf;
    }
}
