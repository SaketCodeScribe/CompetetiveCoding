package com.dsa_algorithms.DynamicProgramming.Solve_x_b_from_x;

public class NoOfOneBits {
    /**
     * we have the following transition function for popcount P(x):
     * P(x+b)=P(x)+1,b=2^m > x
     * T = O(n)
     * @param n
     * @return
     */
    public int[] countBits(int n) {
        int[] ans = new int[n + 1];
        int x = 0;
        int b = 1;

        // [0, b) is calculated
        while (b <= n) {
            // generate [b, 2b) or [b, n) from [0, b)
            while (x < b && x + b <= n) {
                ans[x + b] = ans[x] + 1;
                ++x;
            }
            x = 0; // reset x
            b <<= 1; // b = 2b
        }

        return ans;
    }
}
