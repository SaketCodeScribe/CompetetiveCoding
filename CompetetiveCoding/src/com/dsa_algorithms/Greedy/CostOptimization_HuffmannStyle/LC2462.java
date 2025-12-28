package com.dsa_algorithms.Greedy.CostOptimization_HuffmannStyle;

import java.util.PriorityQueue;

public class LC2462 {
    public long totalCost(int[] costs, int k, int candidates) {
        int n = costs.length, i;
        long cost = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] != b[0] ? Integer.compare(a[0], b[0]) : Integer.compare(a[1], b[1]));

        int[] buckets = initializeQueue(costs, n, candidates, pq);

        while(k-- > 0){
            int[] top = pq.poll();
            cost += top[0];
            if (buckets[1] < n && buckets[0] <= buckets[1]){
                if (top[1] < buckets[0]){
                    pq.offer(new int[]{costs[buckets[0]], buckets[0]++});
                }
                else{
                    pq.offer(new int[]{costs[buckets[1]], buckets[1]--});
                }
            }
        }
        return cost;
    }
    private int[] initializeQueue(int[] costs, int n, int candidates, PriorityQueue<int[]> pq){
        int i;
        int[] buckets = new int[2];

        for(i=0; i<Math.min(n, candidates); i++){
            pq.offer(new int[]{costs[i], i});
        }
        buckets[0] = i;
        for(i=n-1; i>= Math.max(buckets[0], n-candidates); i--){
            pq.offer(new int[]{costs[i], i});
        }
        buckets[1] = i;
        return buckets;
    }
}
