package com.dsa_algorithms.String;

import java.util.Arrays;

public class MinimumDeletionstoMakeStringKSpecial {
    public int minimumDeletions(String word, int k) {
        int i, j, n = word.length(), ans=Integer.MAX_VALUE, temp = 0, pre = 0;
        int[] freq = new int[26];
        for(char ch:word.toCharArray())
            freq[(int)(ch-'a')]++;
        Arrays.sort(freq);
        for(i=0; i<26; i++){
            if (freq[i] > 0){
                temp = 0;
                for(j=25; j>i; j--){
                    if (freq[j] > 0 && freq[j]-freq[i] <= k)
                        break;
                    temp += freq[j]-freq[i]-k;
                }
                ans = Math.min(ans, temp+pre);
                pre += freq[i];
            }
        }
        return ans;
    }
}
