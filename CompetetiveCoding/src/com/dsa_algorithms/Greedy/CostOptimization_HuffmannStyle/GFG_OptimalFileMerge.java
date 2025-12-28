package com.dsa_algorithms.Greedy.CostOptimization_HuffmannStyle;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class GFG_OptimalFileMerge {
    public int minumumCostToMergeFile(int[] files) {
        int cost = 0;
        PriorityQueue<Integer> pq = Arrays.stream(files).boxed().collect(Collectors.toCollection(PriorityQueue::new));

        while(pq.size() > 1){
            int a = pq.poll(), b = pq.poll();
            cost += a+b;
            pq.offer(a+b);
        }
        return cost;
    }
}
