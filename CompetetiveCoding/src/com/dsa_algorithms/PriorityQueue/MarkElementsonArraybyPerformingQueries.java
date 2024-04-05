package com.dsa_algorithms.PriorityQueue;

import java.util.PriorityQueue;

public class MarkElementsonArraybyPerformingQueries {
    public long[] unmarkedSumArray(int[] nums, int[][] queries) {
        int i, n = nums.length, m = queries.length;
        long sum = 0;
        long[] ans = new long[m];
        boolean[] vis = new boolean[n];

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] != b[0] ? a[0]-b[0] : a[1]-b[1]);

        for(i=0; i<n; i++){
            pq.add(new int[]{nums[i], i});
            sum += nums[i];
        }
        i = 0;
        while(i < m && !pq.isEmpty()){
            int k = queries[i][1], j = queries[i][0];
            if (!vis[j])
                sum -= nums[j];
            vis[j] = true;
            while(k > 0 && !pq.isEmpty()){
                int[] temp = pq.peek();
                if (!vis[temp[1]]){
                    sum -= temp[0];
                    vis[temp[1]] = true;
                    k--;
                }
                pq.poll();
            }
            ans[i++] = sum;
        }
        return ans;
    }
}
