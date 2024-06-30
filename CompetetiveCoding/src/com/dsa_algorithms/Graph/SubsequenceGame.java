package com.dsa_algorithms.Graph;

import java.util.*;
public class SubsequenceGame {
    public static int subsequenceGame(int n, int m, String str, String[] arr) {
        // Write your code here.
        int i, j, ans = 0;
        int[][] indexes = new int[n][26];
        int[] chars = new int[26];
        Arrays.fill(chars, -1);

        for(i=0; i<n; i++){
            for(j=0; j<26; j++)
                indexes[i][j] = chars[j];
            chars[str.charAt(i)-'a'] = i;
        }

        for (i=0; i<m; i++){
            int len = arr[i].length(), k = n-1;
            j = len-1;
            while(j >= 0 && k >= 0){
                char ch = arr[i].charAt(j);
                if (ch != str.charAt(k)){
                    if (indexes[k][ch-'a'] < 0)
                        break;
                    k = indexes[k][ch-'a'];
                }
                else{
                    j--;
                    k--;
                }
            }
            if (j < 0)
                ans++;
        }
        return ans;
    }
}
