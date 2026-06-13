package com.dsa_algorithms.SlidingWindow;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class LC239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int i, n = nums.length;
        Deque<Integer> deque = new ArrayDeque<>();
        List<Integer> ans = new ArrayList<>();

        for(i=0; i<n; i++){
            insertInDeque(deque, nums, k, i);
            if (i >= k-1){
                ans.add(nums[deque.peekFirst()]);
            }
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
    private void insertInDeque(Deque<Integer> deque, int[] nums, int k, int i){
        clean(deque, i-k);
        while(!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]){
            deque.pollLast();
        }
        deque.offer(i);
    }
    private void clean(Deque<Integer> deque, int index){
        while(!deque.isEmpty() && deque.peekFirst() <= index){
            deque.pollFirst();
        }
    }
}
