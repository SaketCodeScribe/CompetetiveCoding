package com.dsa_algorithms.DynamicProgramming.LongestCommonSubsequence;

public class LC1035 {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length, i, j;
        int[] curr, prev = new int[n+1];

        for(i=1; i<=m; i++){
            curr = new int[n+1];
            int num = nums1[i-1];
            for(j=1; j<=n; j++){
                if (num == nums2[j-1]){
                    curr[j] = prev[j-1]+1;
                }
                else{
                    curr[j] = Math.max(prev[j], curr[j-1]);
                }
            }
            prev = curr;
        }
        return prev[n];
    }
}
