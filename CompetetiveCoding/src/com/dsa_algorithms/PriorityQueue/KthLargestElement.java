package com.dsa_algorithms.PriorityQueue;

import java.util.*;
public class KthLargestElement {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int num : nums){
            if (pq.size() < k)
                pq.add(num);
            else if (num > pq.peek()){
                pq.poll();
                pq.add(num);
            }
        }
        return pq.peek();
    }
}
