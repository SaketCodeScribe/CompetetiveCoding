package com.dsa_algorithms.practice;

public class L1524 {
    private final int MOD = 1_000_000_007;
    public int numOfSubarrays(int[] arr) {
        int i, n = arr.length, odd = 0, even = 0, ans = 0;

        for(i=0; i<n; i++){
            if ((arr[i] & 1) > 0){
                int temp = odd;
                odd = even+1;
                even = temp;
            }
            else{
                even++;
            }
            ans = (ans+odd)%MOD;
        }
        return ans;
    }
}
