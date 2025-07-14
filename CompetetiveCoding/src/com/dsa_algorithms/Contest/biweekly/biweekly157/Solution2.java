package com.dsa_algorithms.Contest.biweekly.biweekly157;

import java.util.Arrays;

public class Solution2 {
    public static void main(String[] args) {
        System.out.println(maxSubstrings("aaa"));

    }
    public static int maxSubstrings(String word) {
        int i, j, n = word.length(), cnt = 0;
        int[] chars = new int[26];
        for(j=0; j<26; j++){
            chars[j] = -1;
        }

        for(i=0; i<n; i++){
            char ch = word.charAt(i);
            if (chars[ch-'a'] >= 0 && i-chars[ch-'a']+1 >= 4){
                cnt++;
                for(j=0; j<26; j++){
                    chars[j] = -1;
                }
            }
            else{
                if (chars[ch-'a'] == -1) {
                    chars[ch - 'a'] = i;
                }
            }
        }
        return cnt;
    }
}
