package com.dsa_algorithms.Graph.GraphTheory;

import java.util.ArrayList;
import java.util.List;

public class LC261 {
    private void initialize(List<List<Integer>> adj, int[][] edges, int n){
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge:edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
    }
    public boolean validTree(int n, int[][] edges) {
        int i;
        boolean[] vis = new boolean[n];
        List<List<Integer>> adj = new ArrayList<>();
        initialize(adj, edges, n);

        if (!dfs(0, -1, adj, vis)){
            return false;
        }

        for(i=0; i<n; i++){
            if (!vis[i]){
                return false;
            }
        }

        return true;
    }
    private boolean dfs(int node, int parent, List<List<Integer>> adj, boolean[] vis){
        vis[node] = true;

        for(int child:adj.get(node)){
            if (child != parent && (vis[child] || !dfs(child, node, adj, vis))){
                return false;
            }
        }
        return true;
    }
}
