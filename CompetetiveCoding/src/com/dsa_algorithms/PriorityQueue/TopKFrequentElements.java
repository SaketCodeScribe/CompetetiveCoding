package com.dsa_algorithms.PriorityQueue;

import java.util.*;
import java.util.stream.Collectors;

/*
    When using Arrays.stream(int[]) -> it creates an IntStream which is stream on int(primitive)
    datatype.
    To make it Integer type we use boxed(), such that Collectors utility can be applied.
 */
public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        int[] ans = new int[k];
        Map<Integer, Integer> map = Arrays.stream(nums).boxed()
                .collect(Collectors.groupingBy(e -> e, Collectors.summingInt(e -> 1)));
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1]-a[1]);

        for(Map.Entry<Integer, Integer> entry:map.entrySet()){
            pq.add(new int[]{entry.getKey(), entry.getValue()});
        }
        int i = 0;
        while(k-->0 && !pq.isEmpty())
            ans[i++] = pq.poll()[0];
        return ans;
    }
}
