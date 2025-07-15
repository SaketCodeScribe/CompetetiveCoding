package com.dsa_algorithms.Contest.weekly.weekly458;

import java.util.*;

public class Solution4 {
    int ans = 0;
    boolean[] dp;
    public int maxLen(int n, int[][] edges, String label) {
        ans = 0;
        List<List<Integer>> adj = new ArrayList<>();
        boolean[] vis = new boolean[n];

        for(int i=0; i<n; i++) {
            adj.add(new ArrayList<>());
        }
        for(int[]edge:edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        vis = new boolean[n];
        for(int i=0; i < n; i++){
            dp = new boolean[1<<14];
            dfs(adj, i, i, n, label, vis, 0);
            for(int ch:adj.get(i)){
                if (label.charAt(ch) == label.charAt(i)){
                    dfs(adj, ch, i, n, label, vis, 0);
                }
            }
        }
        return ans;
    }

    private void dfs(List<List<Integer>> adj, int leftNode, int rightNode, int n, String label, boolean[] vis, int mask) {
        mask |= (1<<leftNode) | (1<<rightNode);
        if (dp[mask]){
            return;
        }
        vis[leftNode] = vis[rightNode] = true;

        for(int c1:adj.get(leftNode)){
            for(int c2:adj.get(rightNode)){
                if (!vis[c1] && !vis[c2] && c1 != c2 && label.charAt(c1) == label.charAt(c2)){
                    dfs(adj, c1, c2, n, label, vis, mask);
                }
            }
        }
        vis[leftNode] = vis[rightNode] = false;
        ans = Math.max(ans, Integer.bitCount(mask));
        dp[mask] = true;
    }

}
