package com.dsa_algorithms.PriorityQueue.min_max_auxiallary;

import java.util.*;

public class SmallestRangeCoveringEltsFromKLists {
    public int[] smallestRange(List<List<Integer>> nums) {
        int a = -(int)1e5, b = (int)1e5, i = 0, maxelt = Integer.MIN_VALUE;
        PriorityQueue<List<Integer>> minpq = new PriorityQueue<>((p,q) -> Integer.compare(p.get(0),q.get(0)));

        for(List<Integer> num:nums){
            minpq.add(Arrays.asList(num.get(0), i++, 0));
            maxelt = Math.max(maxelt, num.get(0));
        }

        while(true){
            List<Integer> minelt = minpq.peek();
            if (b-a > maxelt-minelt.get(0)){
                a = minelt.get(0); b = maxelt;
            }
            int m = minelt.get(1), n = minelt.get(2);
            if (n+1 == nums.get(m).size())
                break;
            minpq.poll();
            minpq.add(Arrays.asList(nums.get(m).get(n+1), m, n+1));
            maxelt = Math.max(maxelt, nums.get(m).get(n+1));
        }
        return new int[]{a,b};
    }
}
