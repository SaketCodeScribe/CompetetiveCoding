package com.dsa_algorithms.PrefixSum;

public class LC238 {
    public int[] productExceptSelf(int[] nums) {
        int i, n = nums.length, product = 1;
        int[] ans = new int[n];
        ans[0] = 1;
        for(i=1; i<n; i++){
            ans[i] = product = product * nums[i-1];
        }
        product = 1;
        for(i=n-2; i>=0; i--){
            product = product * nums[i+1];
            ans[i] = ans[i] * product;
        }
        return ans;
    }
}
