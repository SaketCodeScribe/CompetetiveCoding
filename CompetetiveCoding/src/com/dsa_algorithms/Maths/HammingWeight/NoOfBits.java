package com.dsa_algorithms.Maths.HammingWeight;

public class NoOfBits {
    /**
     * we can use hamming wt to fetch the answer for x and
     * store this answer to calculate the future answer.
     */
    public int[] countBits(int n) {
        int i, bits;
        int[] ans = new int[n+1];

        for(i=1; i<=n; i++){
            ans[i] = ans[i&(i-1)]+1;
        }
        return ans;
    }
}
