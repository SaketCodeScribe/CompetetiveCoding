package com.dsa_algorithms.Graph;
import java.util.*;
public class MinimumCostWalkinWeightedGraph {
    static class DisjointSet{
        int[] par;
        int[] size;

        public DisjointSet(int n){
            par = new int[n];
            size = new int[n];
            for(int i=0; i<n; i++){
                par[i] = i;
                size[i] = 1;
            }
        }

        public void union(int a, int b){
            int parA = findPar(a), parB = findPar(b), sA, sB;
            sA = size[parA];
            sB = size[parB];
            if (parA == parB)
                return;
            if (sA < sB){
                par[parA] = parB;
                size[parB] += sA;
            }
            else{
                par[parB] = parA;
                size[parA] += sB;
            }
        }

        public int findPar(int a){
            if (a == par[a])
                return a;
            return par[a] = findPar(par[a]);
        }
    }
    public boolean isSameComponent(DisjointSet ds, int a, int b){
        return ds.findPar(a) == ds.findPar(b);
    }
    public int[] minimumCost(int n, int[][] edges, int[][] queries) {
        int  i , q = queries.length;
        int[] ans = new int[q];
        int[] vert = new int[n];
        Arrays.fill(vert, Integer.MAX_VALUE);

        DisjointSet ds = new DisjointSet(n);
        for(int[] edge:edges){
            int wA = vert[ds.findPar(edge[0])], wB = vert[ds.findPar(edge[1])];
            ds.union(edge[0], edge[1]);
            int par = ds.findPar(edge[0]);
            vert[par] = wA&wB&edge[2];
        }
        i = 0;
        for(int[] query:queries){
            int a = query[0], b = query[1];
            if (isSameComponent(ds,a,b))
                ans[i++] = a!=b ? vert[ds.findPar(a)] : 0;
            else
                ans[i++] = -1;
        }
        return ans;
    }
}
