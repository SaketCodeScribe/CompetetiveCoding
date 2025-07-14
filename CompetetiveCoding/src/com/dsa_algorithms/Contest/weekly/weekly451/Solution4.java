package com.dsa_algorithms.Contest.weekly.weekly451;

public class Solution4 {
    public static void main(String[] args) {

    }
    private String ans;
    public String lexicographicallySmallestString(String s) {
        int i, j, n = s.length();
        boolean[][] dp = new boolean[n][n];

        for(i=0; i<n; i++){
            char ch1 = s.charAt(i);
            for(j=i; j>=0; j--){
                char ch2 = s.charAt(j);
                if (i != j){
                    if (i-j == 1){
                        dp[j][i] = (((ch1-'a')-(ch2-'a')+26)% 26 == 1 || ((ch1-'a')-(ch2-'a')+26)% 26 == 25);
                    }
                    else{
                        dp[j][i] = (((ch1-'a')-(ch2-'a')+26)% 26 == 1 || ((ch1-'a')-(ch2-'a')+26)% 26 == 25) && dp[j+1][i-1];
                    }
                }
            }
        }
        Integer[] dp2 = new Integer[n];
        ans = s;
        findSmallestString(s, dp, dp2, 0, n, new StringBuilder());
        return ans;
    }

    private int findSmallestString(String s, boolean[][] dp, Integer[] dp2, int i, int n, StringBuilder sb) {
        if (i == n){
            String temp = sb.toString();
            if (temp.compareTo(ans) < 0){
                ans = temp;
            }
            return 0;
        }
        if (dp2[i] != null){
            return dp2[i];
        }
        int id, result = 0;
        for(id=i; id<n; id++){
            if (dp[i][id]){
                result = Math.max(result, findSmallestString(s, dp, dp2, id+1, n, sb)+id-i+1);
            }
        }
        sb.append(s.charAt(i));
        result = Math.max(result, findSmallestString(s, dp, dp2, i+1, n, sb));
        sb.deleteCharAt(sb.length()-1);
        return dp2[i] = result;
    }

}
