package com.dsa_algorithms.DynamicProgramming;

public class CoinChangeWithFiniteSupply {
    static final int MOD = (int)1e9+7;
    public static int coinChange(int n, int[] coins, int[] freq, int v) {
        // Write your code here.
        int i, j, k;
        long[] curr = new long[v+1], prev = new long[v+1];

        prev[0] = 1;

        for(i=1; i<=n; i++){
            curr = new long[v+1];
            curr[0] = 1;
            for(j=1; j<=v; j++){
                for(k=0; k<=freq[i-1]; k++){
                    if (j >= k*coins[i-1])
                        curr[j] = (curr[j] + prev[j-k*coins[i-1]])%MOD;
                }
            }
            prev = curr;
        }
        return (int)curr[v];
    }
}
