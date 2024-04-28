package com.dsa_algorithms.Tree;

import java.util.ArrayList;
import java.util.List;

public class SumOfDistancesInTree {

    List<List<Integer>> adj;
    int[] res, count;
    int n;
    public int[] sumOfDistancesInTree(int k, int[][] edges) {
        n = k;
        res = new int[n];
        count = new int[n];
        adj = new ArrayList<>();
        for(int i=0; i<n; i++)
            adj.add(new ArrayList<>());
        for(int[] edge:edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        dfs(0,-1,0);
        dfs(0,-1);
        return res;
    }
    void dfs(int node, int par, int cnt){
        res[0] += cnt;
        count[node] = 1;
        for(int child:adj.get(node)){
            if (child != par){
                dfs(child, node, cnt+1);
                count[node] += count[child];
            }
        }
    }
    void dfs(int node, int par){
        if (adj.get(node).isEmpty()){
            res[node] = (par != -1 ? res[par] : 1)+n-2*count[node];
            return;
        }
        for(int child:adj.get(node)){
            if (child != par){
                res[child] = res[node]+n-2*count[child];
                dfs(child, node);
            }
        }
    }
}
