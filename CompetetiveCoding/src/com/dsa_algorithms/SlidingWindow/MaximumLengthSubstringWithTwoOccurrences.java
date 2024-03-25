package com.dsa_algorithms.SlidingWindow;

public class MaximumLengthSubstringWithTwoOccurrences {
    public int maximumLengthSubstring(String s) {
        int i, j, n = s.length(), len = 0;
        String ans = "";
        i = j = 0;
        int[] character = new int[26];
        while (i < n) {
            while (i < n) {
                character[(int) (s.charAt(i) - 'a')]++;
                if (character[(int) (s.charAt(i) - 'a')] > 2)
                    break;
                i++;
            }
            if (len < i - j)
                len = i - j;
            if (i >= n)
                break;
            while (j < i) {
                character[(int) (s.charAt(j++) - 'a')]--;
                if (s.charAt(j - 1) == s.charAt(i))
                    break;
            }
            i++;
        }
        return len;
    }
}
