package com.dsa_algorithms.DynamicProgramming;

import java.util.*;

public class WeightedJobScheduling {
    static long[] dp;
    public static long findMaxProfit(int[] startTime, int[] endTime, int[] profit){

        int n = startTime.length;
        dp = new long[n];
        int[][] jobs = new int[n][3];

        for(int i=0; i<n; i++)
            jobs[i] = new int[]{startTime[i], endTime[i], profit[i]};
        Arrays.sort(jobs, (a, b) -> (a[0]-b[0]));

        return findProfit(0, n, jobs);

    }

    public static long findProfit(int i, int n, int[][] jobs){
        if (i == n)
            return 0;
        if (dp[i] != 0)
            return dp[i];
        long ans = findProfit(i+1, n, jobs);
        int next = findNextJob(i+1, n-1, jobs[i][1], jobs);
        return dp[i] = Math.max(ans, (next > -1 ? findProfit(next, n, jobs) : 0)+jobs[i][2]);
    }

    public static int findNextJob(int low, int high, int tar, int[][] jobs){
        int mid, ans = -1;

        while(low <= high){
            mid = (low+high)>>1;
            if (jobs[mid][0] >= tar){
                high = mid-1;
                ans = mid;
            }
            else
                low = mid+1;
        }
        return ans;
    }
}

