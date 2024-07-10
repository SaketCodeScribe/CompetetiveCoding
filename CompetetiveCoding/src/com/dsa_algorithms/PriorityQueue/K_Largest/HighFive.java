package com.dsa_algorithms.PriorityQueue.K_Largest;

import java.util.*;
public class HighFive {
    public int[][] highFive(int[][] items) {
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        PriorityQueue<Integer> pq;
        int i = 0, sum, n = items.length, cnt;
        List<int[]> ans = new ArrayList<>();

        while(i < n){
            map.putIfAbsent(items[i][0], new PriorityQueue<>());
            pq = map.get(items[i][0]);
            if (pq.size() < 5)
                pq.add(items[i][1]);
            else if (pq.peek() < items[i][1]){
                pq.poll();
                pq.add(items[i][1]);
            }
            i++;
        }

        for(Map.Entry<Integer, PriorityQueue<Integer>> entry:map.entrySet()){
            pq = entry.getValue();
            sum = 0; cnt = 0;
            while(!pq.isEmpty()){
                sum += pq.poll();
                cnt++;
            }
            ans.add(new int[]{entry.getKey(), sum/cnt});
        }
        return ans.toArray(int[][]::new);
    }
}
