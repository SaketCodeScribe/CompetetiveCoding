package com.dsa_algorithms.Graph.Traversal;

public class LC547 {
    boolean[] vis;
    public int findCircleNum(int[][] isConnected) {
        int i, j, n = isConnected.length, provinces = 0;
        vis = new boolean[n];

        for(i=0; i<n; i++){
            if (!vis[i]){
                provinces++;
                dfs(i, n, isConnected);
            }
        }
        return provinces;
    }
    private void dfs(int node, int n, int[][] isConnected){
        vis[node] = true;

        for(int child=0; child<n; child++){
            if (isConnected[node][child] == 1 && !vis[child]){
                dfs(child, n, isConnected);
            }
        }
    }
}
