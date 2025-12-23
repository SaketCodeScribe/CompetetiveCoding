package com.dsa_algorithms.Graph.Traversal;

import java.util.*;

public class LC802 {
    // 1. dfs with time
    int[] times;
    Set<Integer> set;
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        set = new HashSet<>();
        times = new int[n];

        for(int i=0; i<n; i++){
            if (times[i] == 0){
                dfsWithTime(i, n, graph, 1);
            }
        }
        List<Integer> ans = new ArrayList<>(set);
        Collections.sort(ans);
        return ans;
    }
    private int dfsWithTime(int node, int n, int[][] graph, int time){
        times[node] = time;
        int minTime = Integer.MAX_VALUE;

        for(int child:graph[node]){
            minTime = Math.min(minTime, times[child] > 0 ? (set.contains(child) ? time+1 : 1) : dfsWithTime(child, n, graph, time+1));
        }
        if (minTime > time){
            set.add(node);
        }
        else{
            times[node] = 1;
        }
        return times[node] = Math.min(times[node], minTime);
    }

    // 2. topological sort - kahn's algo
    public List<Integer> eventualSafeNodes2(int[][] graph) {
        int i, n = graph.length;
        List<Integer> ans = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        List<List<Integer>> adj = new ArrayList<>();
        int[] indegree = new int[n];

        for(i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        i = 0;
        for(int[] childs:graph){
            for(int child:childs){
                adj.get(child).add(i);
            }
            i++;
        }
        for(List<Integer> childs:adj){
            for(int child:childs){
                indegree[child]++;
            }
        }
        for(i=0; i<n; i++){
            if (indegree[i] == 0){
                queue.add(i);
            }
        }
        while(!queue.isEmpty()){
            int node = queue.poll();
            for(Integer child:adj.get(node)){
                indegree[child]--;
                if (indegree[child] == 0){
                    queue.add(child);
                }
            }
        }
        for(i=0; i<n; i++){
            if (indegree[i] == 0){
                ans.add(i);
            }
        }
        return ans;
    }

}
