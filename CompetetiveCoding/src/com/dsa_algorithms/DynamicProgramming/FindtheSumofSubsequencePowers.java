package com.dsa_algorithms.DynamicProgramming;

import java.util.*;

public class FindtheSumofSubsequencePowers {
    private static final int MOD = (int)Math.pow(10,9)+7;
    public int sumOfPowers(int[] nums, int k) {
        int i, j, n=nums.length;
        long cnt , prevCnt = 0, ans = 0;
        Set<Integer> set = new HashSet<>();
        Arrays.sort(nums);
        for(i=0; i<n; i++){
            for(j=i+1; j<n; j++)
                set.add(Math.abs(nums[i]-nums[j]));
        }
        List<Integer> diffs = new ArrayList<>(set);
        Collections.sort(diffs);
        Collections.reverse(diffs);
        for(Integer diff:diffs){
            int[] next = new int[n];
            for(i=0; i<n; i++){
                for(j=i+1; j<n; j++){
                    if (Math.abs(nums[j]-nums[i]) >= diff)
                        break;
                }
                next[i] = j;
            }
            long[][] dp = new long[n][k+1];
            Arrays.stream(dp).forEach(arr -> Arrays.fill(arr, -1));
            cnt = noOfSubs(0, next, n, k, diff, dp);
            ans = (ans+((cnt-prevCnt)%MOD*diff)%MOD)%MOD;
            prevCnt = cnt;
        }
        return (int)ans;
    }
    public long noOfSubs(int ind, int[] next, int n, int k, int diff, long[][] dp){
        if (ind >= n && k > 0)
            return 0;
        if (k == 0)
            return 1;
        if (dp[ind][k] != -1)
            return dp[ind][k];
        return dp[ind][k] = noOfSubs(ind+1, next, n, k, diff, dp)+noOfSubs(next[ind], next, n, k-1, diff, dp);
    }
}
