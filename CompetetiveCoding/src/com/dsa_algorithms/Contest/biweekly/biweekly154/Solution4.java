package com.dsa_algorithms.Contest.biweekly.biweekly154;

import com.dsa_algorithms.String.Simulation.IntegerToEnglishWords;

import java.util.*;
public class Solution4 {
    public int[] treeQueries(int n, int[][] edges, int[][] queries) {
        int i;
        List<List<List<Integer>>> adj = new ArrayList<>();
        int[] ans = new int[n];
        Map<Integer, int[]> map = new HashMap<>();
        for(i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge:edges){
            adj.get(edge[0]).add(List.of(edge[1], edge[2]));
            adj.get(edge[1]).add(List.of(edge[0], edge[2]));
        }
        dfs(adj, -1, 1, map, 0, n);
        for(i=0; i<queries.length; i++){
            if (queries[i][0] == 2){
//                ans[i] = distance[queries[i][1]];
            }
            else{

            }
        }
        return ans;
    }
    private Map<Integer, int[]> dfs(List<List<List<Integer>>> adj, int parent, int node, Map<Integer, int[]> map, int currDistance, int n){
        int[] curr = new int[n+1];

        for(List<Integer> neighbor:adj.get(node)){
            int child = neighbor.get(0), wt = neighbor.get(1);
            if (child != parent){
                Map<Integer, int[]> currMap = dfs(adj, node, child, map, currDistance, n);
                for(int i=1; i<=n; i++){
//                    curr[i] = distance[i]+wt;
                }
            }
        }
        return new HashMap<>();
    }
}
