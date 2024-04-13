package com.dsa_algorithms.DynamicProgramming;

import java.util.*;
public class DecodeWays {
    long[] dp;
    public int numDecodings(String s) {
        int i, n = s.length();
        dp = new long[n];
        Arrays.fill(dp, -1);
        return (int)numDecodings(0, n, s);
    }
    public long numDecodings(int i, int n, String s){
        if (i >= n)
            return 1;
        if (s.charAt(i) == '0')
            return 0;
        if (dp[i] != -1)
            return dp[i];
        dp[i] = numDecodings(i+1, n, s);
        if (i < n-1 && (s.charAt(i)-'0')*10+(s.charAt(i+1)-'0') <= 26)
            dp[i] += numDecodings(i+2, n, s);
        return dp[i];
    }
}
