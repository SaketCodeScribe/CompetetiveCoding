package com.dsa_algorithms.String;

import java.util.Arrays;

public class KMPAlgorithm {
    public static int strStr(String haystack, String needle) {
        int i, j, m = haystack.length(), n = needle.length(), prev = -1;
        int[] lps = new int[n];
        lps[0] = -1;
        i = 1;
        while (i < n) {
            if (needle.charAt(prev + 1) == needle.charAt(i))
                lps[i++] = ++prev;
            else {
                if (prev == -1) {
                    lps[i++] = -1;
                    continue;
                }
                prev = lps[prev];
            }
        }
        i = j = 0;
        while (i < m && j < n) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            } else {
                if (j == 0) {
                    i++;
                    continue;
                }
                j = lps[j - 1] + 1;
            }
        }
        return j == n ? i - j : -1;
    }

    public static void main(String[] args) {
        System.out.println(strStr("aabaaabaaac", "aabaaac"));
    }
}
