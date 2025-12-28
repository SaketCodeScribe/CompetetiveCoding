package com.dsa_algorithms.Greedy.CostOptimization_HuffmannStyle;

import java.util.PriorityQueue;

public class LC1167 {
    public int connectSticks(int[] sticks) {
        int n = sticks.length;
        int ans = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int stick:sticks){
            pq.offer(stick);
        }

        while(!pq.isEmpty() && pq.size() > 1){
            int newLength = pq.poll()+pq.poll();
            pq.offer(newLength);
            ans += newLength;
        }
        return ans;
    }
}
