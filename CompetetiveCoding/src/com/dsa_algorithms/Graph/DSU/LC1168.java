package com.dsa_algorithms.Graph.DSU;

import java.util.Arrays;

public class LC1168 {
    static class DSU{
        private int[] parent, size;
        int[][] cost;
        public DSU(int n, int[] values){
            parent = new int[n+1];
            size = new int[n+1];
            cost = new int[n+1][2];
            for(int i=1; i<=n; i++){
                parent[i] = i;
                size[i] = 1;
                cost[i][0] = cost[i][1] = values[i-1];
            }
        }
        public int getParent(int a){
            if (a == parent[a]){
                return a;
            }
            return parent[a] = getParent(parent[a]);
        }
        public int getCost(int i){
            return cost[i][0];
        }
        public void union(int a, int b, int weight){
            int parA = getParent(a), parB = getParent(b), delta = weight - Math.max(cost[parA][1], cost[parB][1]);
            if (parA == parB || delta > 0) return ;
            int sA = size[parA], sB = size[parB];
            if (sA > sB){
                parent[parB] = parA;
                size[parA] += sB;
                cost[parA][0] = cost[parA][0] + cost[parB][0] + delta;
                cost[parA][1] = Math.min(cost[parA][1], cost[parB][1]);
            }
            else{
                parent[parA] = parB;
                size[parB] += sA;
                cost[parB][0] = cost[parA][0] + cost[parB][0] + delta;
                cost[parB][1] = Math.min(cost[parA][1], cost[parB][1]);
            }
        }
    }
    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        int i, cost = 0;
        DSU dsu = new DSU(n, wells);
        Arrays.sort(pipes, (a, b) -> Integer.compare(a[2], b[2]));

        for(int[] pipe:pipes){
            dsu.union(pipe[0], pipe[1], pipe[2]);
        }
        for(i=1; i<=n; i++){
            int parent = dsu.getParent(i);
            if (i == parent) cost += dsu.getCost(parent);

        }
        return cost;
    }
}
