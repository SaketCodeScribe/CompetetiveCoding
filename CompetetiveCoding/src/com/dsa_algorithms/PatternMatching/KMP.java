package com.dsa_algorithms.PatternMatching;

import java.util.*;

public class KMP {
    public int strStr(String haystack, String needle) {
        int i, j, m = haystack.length(), n = needle.length();
        int[] lps = new int[n];
        Arrays.fill(lps, -1);
        j = -1;
        i = 1;
        while(i<n && j<i){
            if (needle.charAt(j+1) == needle.charAt(i))
                lps[i++] = ++j;
            else{
                if (j == -1)
                    i++;
                else
                    j = lps[j];
            }
        }
        i = j = 0;
        while(i<m && j<n){
            if (haystack.charAt(i) == needle.charAt(j)){
                i++;
                j++;
            }
            else{
                if (j < 1)
                    i++;
                else
                    j = lps[j-1]+1;
            }
        }
        return j >= n ? i-n : -1;
    }
}
