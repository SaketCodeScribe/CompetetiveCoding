package com.dsa_algorithms.practice;

import java.util.*;

public class L3543 {
    private List<List<List<Integer>>> adj = new ArrayList<>();
    public int maxWeight(int n, int[][] edges, int k, int t) {
        int i;
        TreeSet<Integer>[][] dp = new TreeSet[n][k+1];
        for(i=0; i<n; i++){
            adj.add(new ArrayList<>());
            dp[i][0] = new TreeSet<>(){
                {
                    add(0);
                }
            };
        }
        for(int[] edge:edges){
            adj.get(edge[0]).add(List.of(edge[1], edge[2]));
        }
        int ans = -1;

        for(i=0; i<n; i++){
            dfs(t, i, k, dp);
            if (dp[i][k] != null){
                Integer lower = dp[i][k].lower(t);
                if (lower != null) {
                    ans = Math.max(ans, lower);
                }
            }
        }
        return ans;
    }
    private void dfs(int t, int node, int k, TreeSet<Integer>[][] dp){
        if (k == 0){
            return;
        }
        if (dp[node][k] == null){
            dp[node][k] = new TreeSet<>();
        }
        int weight = -1;
        for(List<Integer> neighbor: adj.get(node)){
            int child = neighbor.get(0), wt = neighbor.get(1);
            if (dp[child][k-1] == null){
                dfs(t, child, k-1, dp);
            }
            dp[node][k].addAll(dp[child][k-1]);
        }
    }
}
