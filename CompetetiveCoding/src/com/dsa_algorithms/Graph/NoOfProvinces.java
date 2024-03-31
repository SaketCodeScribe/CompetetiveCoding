package com.dsa_algorithms.Graph;

public class NoOfProvinces {
    boolean[] vis;
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length, i, prov = 0;
        vis = new boolean[n];

        for(i=0; i<n; i++){
            if (!vis[i]){
                prov++;
                dfs(i, n, isConnected);
            }
        }
        return prov;
    }
    public void dfs(int node, int n, int[][] adj){
        vis[node] = true;

        for(int i=0; i<n; i++){
            if (adj[node][i] == 0 || i == node || vis[i])
                continue;
            dfs(i, n, adj);
        }
    }
}
