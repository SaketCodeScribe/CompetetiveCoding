package com.dsa_algorithms.Maths;

public class LC1922 {
    private final int MOD = (int)(1e9 + 7);
    public int countGoodNumbers(long n) {
        long odd = n/2, even = (n+1)/2;
        return (int) (((pow(5, even)%MOD) * (pow(4, odd)%MOD)) % MOD);
    }

    private long pow(long a, long b){
        if (b == 0) return 1;
        if (b == 1) return a;

        long pow = pow(((a%MOD) * (a%MOD)) % MOD, b/2);
        if (b%2 != 0)
            pow = ((pow%MOD) * (a%MOD)) % MOD;
        return pow;
    }
}
