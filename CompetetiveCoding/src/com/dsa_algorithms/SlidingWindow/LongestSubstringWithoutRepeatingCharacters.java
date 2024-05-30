package com.dsa_algorithms.SlidingWindow;

public class LongestSubstringWithoutRepeatingCharacters {
    public static int uniqueSubstrings(String input)
    {
        int i = 0, n = input.length(), j = 0, ans = 0;
        int[] chars = new int[26];

        while(i < n){
            char ch = input.charAt(i);
            chars[ch-'a']++;
            while ( j<i && chars[ch-'a'] > 1){
                j++;
                if (ch == input.charAt(j-1))
                    break;
            }
            ans = Math.max(ans, (++i)-j);
        }
        return ans;
    }
}
