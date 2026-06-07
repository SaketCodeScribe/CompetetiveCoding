package com.dsa_algorithms.SlidingWindow;

public class LC424 {
    public int characterReplacement(String s, int k) {
        int n = s.length(), currK = k, left = 0, right = 0, ans = 0;
        int[] freq = new int[26];

        while(right < n){
            char curr = s.charAt(right);
            freq[curr-'A']++;
            char top = getTop(freq);
            currK = computeK(freq, top, k);
            if (currK < 0){
                left = slideFromLeft(left, right, s, freq, top, curr, currK, k);
            }

            right++;
            ans = Math.max(ans, right - left);
        }
        return ans;
    }

    private char getTop(int[] freq){
        int mx = 0;
        for(int i=0; i<26; i++){
            if (freq[i] > freq[mx]){
                mx = i;
            }
        }
        return (char)(mx + 'A');
    }

    private int computeK(int[] freq, char top, int k){

        for(int i=0; i<26; i++){
            if ((top-'A') != i) k -= freq[i];
        }
        return k;
    }

    private int slideFromLeft(int left, int right, String s, int[] freq, char top, char curr, int currK, int k){
        while(left < right && currK < 0){
            freq[s.charAt(left++)-'A']--;
            char newTop = getTop(freq);
            currK = computeK(freq, newTop, k);
        }
        return left;
    }
}
