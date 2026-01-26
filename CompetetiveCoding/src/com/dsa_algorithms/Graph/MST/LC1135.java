package com.dsa_algorithms.Graph.MST;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class LC1135 {
    //1. Prims algorithm
    public int minimumCost(int n, int[][] connections) {
        List<List<int[]>> adj = new ArrayList<>();
        long[] costs = new long[n+1];
        boolean[] vis = new boolean[n+1];
        initialize(connections, n, adj, costs);

        return minimumCost(n, adj, costs, vis);
    }
    private void initialize(int[][] connections, int n, List<List<int[]>> adj, long[] costs){
        Arrays.fill(costs, Integer.MAX_VALUE);
        costs[0] = 0;
        for(int i=0; i<=n; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge:connections){
            adj.get(edge[0]).add(new int[]{edge[1], edge[2]});
            adj.get(edge[1]).add(new int[]{edge[0], edge[2]});
        }
    }
    private int minimumCost(int n, List<List<int[]>> adj, long[] costs, boolean[] vis){
        int minCost = 0, vertices = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));

        vis = new boolean[n+1];
        pq.offer(new int[]{1, 0});

        while(!pq.isEmpty()){
            int[] top = pq.poll();
            int node = top[0], nodeWeight = top[1];
            if (vis[node]){
                continue;
            }
            vis[node] = true;
            vertices++;
            minCost += nodeWeight;
            for(int[] vertice:adj.get(node)){
                int child = vertice[0], weight = vertice[1];
                if (!vis[child]){
                    pq.offer(new int[]{child, weight});
                }
            }
        }
        return vertices == n ? minCost : -1;
    }

    // 2. Kruskal's algorithm
    static class DSU{
        int[] parent, size;
        public DSU(int n){
            parent = new int[n+1];
            size = new int[n+1];
            for(int i=0; i<n; i++){
                parent[i] = i;
                size[i] = 1;
            }
        }
        public int getParent(int node){
            if (node == parent[node]){
                return node;
            }
            return parent[node] = getParent(parent[node]);
        }
        public boolean union(int a, int b){
            int parA = getParent(a), parB = getParent(b);
            if (parA == parB){
                return false;
            }
            int sizeA = size[parA], sizeB = size[parB];
            if (sizeA > sizeB){
                parent[parB] = parA;
                size[parA] += sizeB;
            }
            else{
                parent[parA] = parB;
                size[parB] += sizeA;
            }
            return true;
        }
    }
    public int minimumCost2(int n, int[][] connections) {
        DSU dsu = new DSU(n+1);
        Arrays.sort(connections, (a,b) -> Integer.compare(a[2], b[2]));

        return minimumCost(n, connections, dsu);
    }
    private int minimumCost(int n, int[][] connections, DSU dsu){
        int i, cost = 0, components = 0;
        for(i=0; i<connections.length; i++){
            if (dsu.union(connections[i][0], connections[i][1])){
                cost += connections[i][2];
            }
        }
        for(i=1; i<=n; i++){
            if (dsu.getParent(i) == i){
                components++;
            }
        }
        return components > 1 ? -1 : cost;
    }
}
