package com.dsa_algorithms.Stack;

import java.util.Arrays;
import java.util.Stack;

public class LC503 {
    public int[] nextGreaterElements(int[] nums) {
        int i, n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        Stack<Integer> stack = new Stack<>();

        for(i=0; i<2*n-1; i++){
            int id = i%n;
            while(!stack.isEmpty() && nums[stack.peek()] < nums[id]){
                ans[stack.pop()] = nums[id];
            }
            stack.push(id);
        }
        return ans;
    }
}
