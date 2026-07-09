package com.dsa_algorithms.Graph;

public class LC2492 {
    static class DSU{
        int[] parent, size, minCost;
        public DSU(int n){
            parent = new int[n+1];
            size = new int[n+1];
            minCost = new int[n+1];
            for(int i=1; i<=n; i++){
                parent[i] = i;
                size[i] = 1;
                minCost[i] = Integer.MAX_VALUE;
            }
        }

        public int getParent(int a){
            if (a == parent[a]) return a;
            return parent[a] = getParent(parent[a]);
        }

        public void union(int a, int b, int cost){
            int parA = getParent(a), parB = getParent(b);
            int sizeA = size[parA], sizeB = size[parB];

            if (parA == parB) {
                minCost[parA] = Math.min(cost, minCost[parA]);
            }
            else if (sizeA < sizeB){
                parent[parA] = parB;
                size[parB] += sizeA;
                minCost[parB] = Math.min(cost, Math.min(minCost[parA], minCost[parB]));
            }
            else{
                parent[parB] = parA;
                size[parA] += sizeB;
                minCost[parA] = Math.min(cost, Math.min(minCost[parA], minCost[parB]));
            }
        }

        public int getCost(int a){
            return minCost[getParent(a)];
        }
    }
    public int minScore(int n, int[][] roads) {
        DSU dsu = new DSU(n+1);

        for(int[] road:roads){
            dsu.union(road[0], road[1], road[2]);
        }

        return Math.min(dsu.getCost(1), dsu.getCost(n));
    }
}
