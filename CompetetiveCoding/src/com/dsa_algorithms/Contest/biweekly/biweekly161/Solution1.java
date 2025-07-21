package com.dsa_algorithms.Contest.biweekly.biweekly161;

import java.util.Arrays;

public class Solution1 {
    public long splitArray(int[] nums) {
        int i, n = nums.length;
        boolean[] isPrime = getPrimeArray(n);

        long sum = 0;

        for(i=0; i<n; i++){
            if (isPrime[i]){
                sum += nums[i];
            }
            else{
                sum -= nums[i];
            }
        }
        return Math.abs(sum);
    }

    private boolean[] getPrimeArray(int n) {
        int i, j;
        boolean[] prime = new boolean[n];
        Arrays.fill(prime, true);
        prime[0] = prime[1] = false;

        for(i=0; i<n; i++){
            if (prime[i]){
                for(j=2; j*i<n; j++){
                    prime[i*j] = false;
                }
            }
        }
        return prime;
    }
}
