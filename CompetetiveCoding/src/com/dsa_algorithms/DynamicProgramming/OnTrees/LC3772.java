package com.dsa_algorithms.DynamicProgramming.OnTrees;

import java.util.ArrayList;
import java.util.List;

public class LC3772 {
    public int[] maxSubgraphScore(int n, int[][] edges, int[] good) {
        List<List<Integer>> adj = new ArrayList<>();
        int[] dp = new int[n], ans = new int[n];
        initialize(n, adj, edges, good);
        dfs(0, -1, adj, good, dp);

        scores(0, -1, adj, good, dp, ans);
        return ans;
    }
    private void initialize(int n, List<List<Integer>> adj, int[][] edges, int[] good){
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
            good[i] = good[i] == 0 ? -1 : 1;
        }
        for(int[] edge:edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
    }
    private int dfs(int node, int parent, List<List<Integer>> adj, int[] good, int[] dp){
        int scores = 0;
        for(int child:adj.get(node)){
            if (child != parent) scores += Math.max(0, dfs(child, node, adj, good, dp));
        }
        return dp[node] = scores+good[node];
    }
    private void scores(int node, int parent, List<List<Integer>> adj, int[] good, int[] dp, int[] ans){
        for(int child:adj.get(node)){
            if (child != parent) ans[node] += Math.max(0, dp[child]);
            else ans[node] += ans[child] >= 0 ? Math.max(0, ans[child] - Math.max(dp[node], 0)) : 0;
        }
        ans[node] += good[node];
        for(int child:adj.get(node)){
            if (child != parent) scores(child, node, adj, good, dp, ans);
        }
    }
}
