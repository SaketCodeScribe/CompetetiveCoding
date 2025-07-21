package com.dsa_algorithms.Contest.biweekly.biweekly161;

import java.util.*;

public class Solution3 {public int findMaxPathScore(int[][] edges, boolean[] online, long k) {
    if (edges.length == 0){
        return -1;
    }
    int n = online.length;
    List<List<List<Integer>>> adj = new ArrayList<>();

    for(int i=0; i<n; i++){
        adj.add(new ArrayList<>());
    }
    for(int[] edge:edges){
        if (online[edge[0]] && online[edge[1]]) {
            adj.get(edge[0]).add(List.of(edge[1], edge[2]));
        }
    }
    int low = 1, ans = -1, mid;
    int high = Arrays.stream(edges).max((a,b) -> Integer.compare(a[2],b[2])).get()[2];

    while(low <= high){
        mid = low + (high-low)/2;
        if (isPathPossible(adj, n, mid, k)){
            ans = mid;
            low = mid+1;
        }
        else{
            high = mid-1;
        }
    }
    return ans;
}
    private boolean isPathPossible(List<List<List<Integer>>> adj, int n, int wt, long k){
        return minimumSpanningTree(adj, wt, k) != Long.MAX_VALUE;
    }
    private long minimumSpanningTree(List<List<List<Integer>>> adj, int weight, long k) {
        PriorityQueue<List<Long>> pq = new PriorityQueue<>((a,b) -> Long.compare(a.get(1), b.get(1)));
        int n = adj.size();
        long[] sum = new long[n];
        Arrays.fill(sum, Long.MAX_VALUE);
        sum[0] = 0;
        pq.offer(List.of(0l, 0l));

        while(!pq.isEmpty()){
            List<Long> top = pq.poll();
            int node = top.get(0).intValue();
            long cost = top.get(1);
            if (sum[node] < cost){
                continue;
            }
            if (node == n-1){
                return cost;
            }
            for(List<Integer> neighbor:adj.get(node)){
                int child = neighbor.get(0), wt = neighbor.get(1);
                if (wt >= weight && sum[child] > cost+wt && cost+wt <= k){
                    sum[child] = cost+wt;
                    pq.offer(List.of((long)child, sum[child]));
                }
            }
        }
        return Long.MAX_VALUE;
    }
}
