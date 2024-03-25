package com.dsa_algorithms.PriorityQueue;

import java.util.*;

public class MostFrequentIDs {
    public long[] mostFrequentIDs(int[] nums, int[] freq) {
        PriorityQueue<long[]> pq = new PriorityQueue<long[]>((a, b) -> (int) (b[1] - a[1]));
        int i = 0, n = nums.length, j = 0;
        long[] ans = new long[n];
        Map<Integer, Long> map = new HashMap<>();

        while (i < n) {
            map.put(nums[i], map.getOrDefault(nums[i], new Long(0)) + freq[i]);
            while (!pq.isEmpty()) {
                long[] num = pq.peek();
                if (map.get((int) num[0]) != num[1])
                    pq.poll();
                else
                    break;
            }
            pq.add(new long[]{nums[i], map.get(nums[i++])});
            ans[j++] = pq.peek()[1];
        }
        return ans;
    }
}
