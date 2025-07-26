package com.dsa_algorithms.practice;

public class L1340 {
    public int maxJumps(int[] arr, int d) {
        int n = arr.length, ans = 0;
        Integer[] dp = new Integer[n];

        for(int i=0; i<n; i++){
            helper(arr, n, d, i, dp);
            ans = Math.max(ans, 1+dp[i]);
        }
        return ans;
    }
    private int helper(int[] arr, int n, int d, int i, Integer[] dp){
        if (dp[i] != null){
            return dp[i];
        }
        int count = 0;
        for(int j = i+1; j <= Math.min(i+d, n-1) && arr[i] > arr[j]; j++){

            count = Math.max(count, 1+helper(arr, n, d, j, dp));
        }
        for(int j=i-1; j >= Math.max(i-d, 0) && arr[i] > arr[j]; j--){
            count = Math.max(count, 1+helper(arr, n, d, j, dp));
        }
        return dp[i] = count;
    }
}
