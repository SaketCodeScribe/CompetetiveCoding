package com.dsa_algorithms.practice;

import java.util.*;
public class L3544 {
    List<List<Integer>> adj;
    public long subtreeInversionSum(int[][] edges, int[] nums, int k) {
        int i, n = nums.length;
        adj = new ArrayList<>();
        Long[][][] dp = new Long[n][2][k+1];

        for(i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge:edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        return Math.max(dfs(nums, n, k, -1, 0, 0, k, dp), dfs(nums, n, k, -1, 0, 1, 1, dp));
    }
    private long dfs(int[] nums, int n, int k, int parent, int node,
                     int parity, int dist, Long[][][] dp){
        if (dp[node][parity][dist] != null){
            return dp[node][parity][dist];
        }
        long sum = parity == 1 ? -nums[node] : nums[node];
        for(int child:adj.get(node)){
            if (child != parent){
                long curr = 0;
                if (parity == 1){
                    curr = dfs(nums, n, k, node, child, 1, Math.min(dist+1, k), dp);
                    if (dist >= k){
                        curr = Math.max(curr,
                                dfs(nums, n, k, node, child, 0, 1, dp));
                    }
                }
                else{
                    curr = dfs(nums, n, k, node, child, 0, Math.min(dist+1, k), dp);
                    if (dist >= k){
                        curr = Math.max(curr,
                                dfs(nums, n, k, node, child, 1, 1, dp));
                    }
                }
                sum += curr;
            }
        }
        return dp[node][parity][dist] = sum;
    }
}
