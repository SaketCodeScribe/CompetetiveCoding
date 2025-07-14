package com.dsa_algorithms.Contest.biweekly.biweekly160;

import java.util.*;
public class Solution3 {
    public int minTime(int n, int[][] edges) {
        int i, ans = -1;
        List<List<List<Integer>>> adj = new ArrayList<>();
        PriorityQueue<List<Integer>> pq = new PriorityQueue<>((a,b) -> Integer.compare(a.get(1), b.get(1)));
        int[] time = new int[n];
        Arrays.fill(time, Integer.MAX_VALUE);

        for(i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] edge:edges){
            adj.get(edge[0]).add(List.of(edge[1], edge[2], edge[3]));
        }
        time[0] = 0;
        pq.offer(List.of(0, 0));

        while(!pq.isEmpty()){
            List<Integer> list = pq.poll();
            int node = list.get(0), t = list.get(1);
            if (node == n-1){
                ans = t;
                break;
            }
            if (time[node] < t){
                continue;
            }
            for(List<Integer> neighbor:adj.get(node)){
                int child = neighbor.get(0), st = neighbor.get(1), end = neighbor.get(2);
                if (t <= end){
                    int curr = Math.max(t, st);
                    if (time[child] > curr){
                        time[child] = curr+1;
                        pq.offer(List.of(child, time[child]));
                    }
                }
            }

        }
        return ans;
    }
    public static void main(String[] args) {

    }
}
