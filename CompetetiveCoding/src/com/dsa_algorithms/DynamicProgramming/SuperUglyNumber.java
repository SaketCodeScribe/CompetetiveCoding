package com.dsa_algorithms.DynamicProgramming;

import java.util.*;

public class SuperUglyNumber {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int i, j;
        if (n == 1)
            return 1;
        long[] dp = new long[n+1];
        int[] freq = new int[primes.length];
        dp[1] = 1;
        Arrays.fill(freq, 1);

        for(i=2; i<=n; i++){
            dp[i] = Integer.MAX_VALUE;
            for(j=0; j<primes.length; j++)
                dp[i] = Math.min(dp[i], primes[j]*dp[freq[j]]);
            for(j=0; j<primes.length; j++)
                if (dp[i] == primes[j]*dp[freq[j]])
                    freq[j]++;
        }

        return (int)dp[n];
    }
}
