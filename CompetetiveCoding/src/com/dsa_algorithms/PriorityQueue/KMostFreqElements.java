package com.dsa_algorithms.PriorityQueue;
import java.util.*;
import java.util.stream.Collectors;

public class KMostFreqElements {
    public static int[] KMostFrequent(int n, int k, int[] arr) {
        // Write your code here.
        Map<Integer, Long> freq = Arrays.stream(arr).boxed().collect(Collectors.groupingBy(e -> e, Collectors.counting()));
        PriorityQueue<long[]> pq = new PriorityQueue<>((a,b) -> Double.compare(a[1], b[1]));

        for(Map.Entry<Integer, Long> entry : freq.entrySet()){
            pq.add(new long[]{entry.getKey(), entry.getValue()});
            if (pq.size() > k)
                pq.poll();
        }
        int[] result = new int[k];
        int index = 0;
        while (!pq.isEmpty()) {
            result[index++] = (int)pq.poll()[0];
        }

        return result;
    }
}
