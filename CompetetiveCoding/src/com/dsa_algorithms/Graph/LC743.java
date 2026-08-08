package com.dsa_algorithms.Graph;

import java.util.*;

public class LC743 {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<Map.Entry<Integer, Integer>>> graph = new ArrayList<>();
        int[] cost = new int[n+1];

        createGraph(graph, times, n);

        minCost(graph, cost, k);

        return getDelayTime(cost, n);
    }
    private void minCost(List<List<Map.Entry<Integer, Integer>>> graph, int[] cost, int k) {
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.getValue(), b.getValue()));
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[k] = 0;
        pq.offer(Map.entry(k, 0));

        while(!pq.isEmpty()) {
            Map.Entry<Integer, Integer> top = pq.poll();
            int key = top.getKey();
            int time = top.getValue();
            if (time > cost[key]) continue;

            for(Map.Entry<Integer, Integer> child:graph.get(key)) {
                int _key = child.getKey();
                int _wt = child.getValue();
                if (cost[_key] > time + _wt) {
                    cost[_key] = time + _wt;
                    pq.offer(Map.entry(_key, cost[_key]));
                }
            }
        }
    }
    private void createGraph(List<List<Map.Entry<Integer, Integer>>> graph, int[][] times, int n) {
        for(int i=0; i<=n; i++) {
            graph.add(new ArrayList<>());
        }
        for(int[] time:times) {
            graph.get(time[0]).add(Map.entry(time[1], time[2]));
        }
    }
    private int getDelayTime(int[] cost, int n) {
        int ans = -1;
        for(int i=1; i<=n; i++) {
            int c = cost[i];
            if (c == Integer.MAX_VALUE) return -1;
            ans = Math.max(ans, c);
        }
        return ans;
    }
}
