package com.dsa_algorithms.Graph.Cycle;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LC207  {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int i;
        boolean[] vis = new boolean[numCourses];
        Set<Integer> currStack;
        List<List<Integer>> adj = new ArrayList<>();
        initialize(adj, numCourses, prerequisites);

        for(i=0; i<numCourses; i++){
            if (!vis[i]){
                currStack = new HashSet<>();
                if (!dfs(i, adj, vis, currStack)){
                    return false;
                }
            }
        }
        for(i=0; i<numCourses; i++){
            if (!vis[i]){
                return false;
            }
        }
        return true;
    }
    private void initialize(List<List<Integer>> adj, int n, int[][] edges){
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge:edges){
            adj.get(edge[1]).add(edge[0]);
        }
    }
    private boolean dfs(int node, List<List<Integer>> adj, boolean[] vis, Set<Integer> currStack){
        vis[node] = true;
        currStack.add(node);

        for(int child:adj.get(node)){
            if (currStack.contains(child)){
                return false;
            }
            if (!vis[child] && !dfs(child, adj, vis, currStack)){
                return false;
            }
        }
        currStack.remove(node);
        return true;
    }
}
