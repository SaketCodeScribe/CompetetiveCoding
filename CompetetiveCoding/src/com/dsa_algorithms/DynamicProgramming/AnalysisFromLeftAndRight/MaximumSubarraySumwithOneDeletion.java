package com.dsa_algorithms.DynamicProgramming.AnalysisFromLeftAndRight;

public class MaximumSubarraySumwithOneDeletion {
    public int maximumSum(int[] arr) {
        int i, n = arr.length, sum = 0, ans = Integer.MIN_VALUE;

        int[] left = new int[n];
        int[] right = new int[n];

        sum = arr[0];
        left[0] = -1;
        for(i=1; i<n; i++){
            if (sum >= 0)
                left[i] = sum;
            else{
                sum = 0;
                left[i] = -1;
            }
            sum += arr[i];
        }

        sum = arr[n-1];
        right[n-1] = -1;
        for(i=n-2; i>=0; i--){
            if (sum >= 0)
                right[i] = sum;
            else{
                sum = 0;
                right[i] = -1;
            }
            sum += arr[i];
        }

        for(i=0; i<n; i++){
            ans = Math.max(ans, arr[i]);
            if (left[i] != -1 && right[i] != -1){
                ans = Math.max(ans, Math.max(arr[i], 0)+Math.max(left[i], Math.max(right[i], left[i]+right[i])));
            }
            else if (left[i] != -1)
                ans = Math.max(ans, left[i]);
            else if (right[i] != -1)
                ans = Math.max(ans, right[i]);
        }
        return ans;
    }
}
