package com.dsa_algorithms.String;

public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] arr, int n) {
        // Write your code here
        String ans = arr[0];
        int i, j;

        for(i=1; i<n; i++){
            String str = arr[i];
            for(j=0; j<str.length() && j<ans.length(); j++){
                if (str.charAt(j) != ans.charAt(j))
                    break;
            }
            ans = ans.substring(0,j);
            if (ans.isEmpty())
                return ans;
        }
        return ans;
    }
}
