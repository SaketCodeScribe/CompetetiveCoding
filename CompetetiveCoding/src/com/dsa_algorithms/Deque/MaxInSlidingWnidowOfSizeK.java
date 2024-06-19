package com.dsa_algorithms.Deque;

import java.util.*;

public class MaxInSlidingWnidowOfSizeK {
    public static ArrayList<Integer> getMaximumOfSubarrays(ArrayList<Integer> nums, int k)
    {
        //	  Write your code here.
        ArrayList<Integer> ans = new ArrayList<>();
        Deque<int[]> deque = new LinkedList<>();
        int i=0;

        while (i < k){
            while(!deque.isEmpty() && deque.peekLast()[1] <= nums.get(i))
                deque.pollLast();
            deque.addLast(new int[]{i, nums.get(i++)});
        }
        ans.add(deque.peekFirst()[1]);
        while(i < nums.size()){
            while(!deque.isEmpty() && deque.peekFirst()[0] <= i-k)
                deque.pollFirst();
            while(!deque.isEmpty() && deque.peekLast()[1] <= nums.get(i))
                deque.pollLast();
            deque.add(new int[]{i, nums.get(i++)});
            ans.add(deque.peekFirst()[1]);
        }
        return ans;
    }
}
