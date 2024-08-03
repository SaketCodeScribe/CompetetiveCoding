package com.dsa_algorithms.TwoPointer.substring_or_subarray;

public class LongestRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k) {
        int i, left = 0, right = 0, n = s.length(), ans = 0, maxFreq = 0;
        int[] cnt = new int[26];

        while(right < n){
            maxFreq = 0;
            cnt[s.charAt(right)-'A']++;
            for(i=0; i<26; i++)
                maxFreq = Math.max(maxFreq, cnt[i]);

            if (right-left-maxFreq+1 <= k)
                ans = Math.max(ans, ++right-left);
            else{
                cnt[s.charAt(left++)-'A']--;
                cnt[s.charAt(right)-'A']--;
            }
        }
        return ans;
    }
}
