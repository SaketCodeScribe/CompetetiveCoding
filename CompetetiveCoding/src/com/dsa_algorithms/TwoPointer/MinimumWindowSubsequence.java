package com.dsa_algorithms.TwoPointer;

public class MinimumWindowSubsequence {
    public static String minWindow(String S, String T) {
        int i, j, k, m = S.length(), n = T.length();
        if (n >  m)
            return "";
        if (n == m)
            return S.contains(T) ? S : "";
        if (n == 1)
            return S.contains(T) ? T : "";
        String ans="";
        i = j = 0;
        while(i < m && j<n){
            if(S.charAt(i) == T.charAt(j)){
                j++;
            }
            if (j == n){
                j = n-1;
                k = i;
                while (j > -1){
                    if(S.charAt(k) == T.charAt(j))
                        j--;
                    k--;
                }
                String str = S.substring(++k, i+1);
                if (ans.isEmpty() || ans.length() > str.length())
                    ans = str;
                j = 0;
                i = k;
            }
            i++;
        }
        return ans;
    }
}
