package com.dsa_algorithms.Maths;

public class CountSetBits {
    static final int MOD = (int)1e9+7;
    public static int countSetBits(int n)
    {
        //    Write your code here.
        long ans = 0;
        long[] dp = new long[32];
        dp[0] = 1;
        for(int i=1; i<32; i++)
            dp[i] = (dp[i-1]*2%MOD+(long)Math.pow(2, i)%MOD)%MOD;
        while (n > 0){
            int bits = countBits(n);
            int val = (1 << bits)-1;
            int diff = n-val;
            ans = (ans + (bits > 0 ? dp[bits-1] : 0) + diff)%MOD;
            n = n-val-1;
        }
        return (int)ans;
    }
    public static int countBits(int n){
        int i;
        for(i = 31; i >= 0; i--){
            if ((n & (1<<i)) > 0)
                break;
        }
        return i;
    }
}
