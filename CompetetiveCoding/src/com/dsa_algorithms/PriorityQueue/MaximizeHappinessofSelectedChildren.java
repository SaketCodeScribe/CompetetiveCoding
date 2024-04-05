package com.dsa_algorithms.PriorityQueue;

import java.util.PriorityQueue;

public class MaximizeHappinessofSelectedChildren {
    public long maximumHappinessSum(int[] happiness, int k) {
        int n = happiness.length, i = 0;
        long sum = 0, cnt=0;
        PriorityQueue<Long> pq = new PriorityQueue<>((a, b) -> (int)(long)(b-a));
        for(int happy:happiness)
            pq.add((long)happy);
        while(k-->0)
            sum = sum+Math.max(pq.poll()-cnt++,0);
        return sum;
    }
}
