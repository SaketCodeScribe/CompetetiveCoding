package com.dsa_algorithms.Contest.weekly.weekly456;
import java.util.*;

public class Solution2 {
    public int[] longestCommonPrefix(String[] words) {
        int i, j, n = words.length;
        int[] left = new int[n], right = new int[n];
        int[] ans = new int[n];

        for(i=1; i<n; i++){
            String word1 = words[i], word2 = words[i-1];
            j = getPrefixLength(word1, word2);
            left[i] = Math.max(left[i-1], j);
        }
        for(i=n-2; i>=0; i--){
            String word1 = words[i], word2 = words[i+1];
            j = getPrefixLength(word1, word2);
            right[i] = Math.max(i+1, j);
        }
        for(i=0; i<n; i++){
            if (i == 0){
                ans[i] = right[i+1];
            }
            else if (i == n-1){
                ans[i] = left[i-1];
            }
            else{
                ans[i] = Math.max(left[i-1], right[i+1]);
                String word1 = words[i-1], word2 = words[i+1];
                j = getPrefixLength(word1, word2);
                ans[i] = Math.max(ans[i], j);
            }
        }
        return ans;
    }

    private static int getPrefixLength(String word1, String word2) {
        int j;
        for (j = 0; j < Math.min(word1.length(), word2.length()); j++) {
            if (word1.charAt(j) != word2.charAt(j)) {
                break;
            }
        }
        return j;
    }
}
