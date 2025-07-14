package com.dsa_algorithms.Contest.weekly.weekly455;

public class Solution2 {
    public static String smallestPalindrome(String s) {
        int i, j, n = s.length();
        if (n == 1){
            return s;
        }
        char ch = '#';
        int[] freq = new int[26];
        char[] chars = new char[n];

        for(i=0; i<n; i++){
            freq[s.charAt(i)-'a']++;
        }
        i = j = 0;
        while(i < n/2){
            while(j < 26 && freq[j] < 2){
                if (freq[j] == 1){
                    ch = (char)('a'+j);
                }
                j++;
            }
            while(i < n/2 && freq[j] > 1){
                chars[i] = (char)('a'+j);
                chars[n-i-1] = (char)('a'+j);
                freq[j] -= 2;
                i++;
            }
        }
        j = 0;
        while(j < 26){
            if (freq[j] == 1){
                chars[i] = (char)(j+'a');
            }
            j++;
        }
        return String.valueOf(chars);
    }
    public static void main(String[] args) {
        System.out.println(smallestPalindrome("yzzzzaxxtabbatxxazzzzy"));
    }
}
