package com.dsa_algorithms.Maths;

public class LC4002 {
    private final int MOD = (int)(1e9+7);

    public int countValidSequences(int n, int k) {
        return (permutation(n-1, k-1) - ( (n-k) % 2 == 0 ? permutation((n-k)/2 + k - 1, k - 1) : 0 ) + MOD) % MOD;
    }

    private int permutation(int n, int k) {
        long numerator = 1;
        long denominator = 1;

        for (long i = 1; i <= k; i++) {
            numerator = numerator * ((n - i + 1) % MOD) % MOD;
            denominator = denominator * i % MOD;
        }
        return (int)(numerator * modPow(denominator, MOD-2) % MOD);
    }

    private long modPow(long base, long exp) {
        long result = 1;

        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = result * base % MOD;
            }
            base = base * base % MOD;
            exp >>= 1;
        }

        return result;
    }
}
