package com.dsa_algorithms.practice;

public class L3269 {
    public int minLargest(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        Integer[][][] dp = new Integer[m+1][n+1][2];

        return minLargest(nums1, nums2, m, n, 0, 0, 0, dp);
    }

    private int minLargest(int[] nums1, int[] nums2, int m, int n,
                           int i, int j, int parity, Integer[][][] dp) {
        i = Math.min(i, m);
        j = Math.min(j, n);
        if (i >= m && j >= n){
            return 0;
        }
        if (dp[i][j][parity] != null){
            return dp[i][j][parity];
        }
        int largest = Integer.MAX_VALUE;
        if (parity == 0){
            if (i < m) {
                if (nums1[i] == 0) {
                    largest = minLargest(nums1, nums2, m, n, i + 1, j, nums1[i], dp) + 2;
                }
                else{
                    largest = minLargest(nums1, nums2, m, n, i + 1, j, nums1[i], dp) + 1;
                }
            }
            if (j < n){
                if (nums2[j] == 0) {
                    largest = Math.min(largest,
                            minLargest(nums1, nums2, m, n, i, j+1, nums2[j], dp) + 2);
                }
                else{
                    largest = Math.min(largest,
                            minLargest(nums1, nums2, m, n, i, j+1, nums2[j], dp) + 1);
                }
            }
        }
        else{
            if (i < m) {
                if (nums1[i] == 0) {
                    largest = minLargest(nums1, nums2, m, n, i + 1, j, nums1[i], dp) + 1;
                }
                else{
                    largest = minLargest(nums1, nums2, m, n, i + 1, j, nums1[i], dp) + 2;
                }
            }
            if (j < n){
                if (nums2[j] == 0) {
                    largest = Math.min(largest,
                            minLargest(nums1, nums2, m, n, i, j+1, nums2[j], dp) + 1);
                }
                else{
                    largest = Math.min(largest,
                            minLargest(nums1, nums2, m, n, i, j+1, nums2[j], dp) + 2);
                }
            }
        }

        return dp[i][j][parity] = largest;
    }
}
