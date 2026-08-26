package com.dsa_algorithms.Stack;

import java.util.Arrays;
import java.util.Stack;

public class LC503 {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length, i, j = -1;
        int[] stack = new int[n];
        int[] result = new int[n];
        Arrays.fill(result, -1);


        for(i=0; i<2*n; i++) {
            while(j >= 0 && nums[stack[j%n]] < nums[i%n]) {
                result[stack[(j--)%n]] = nums[i%n];
            }
            stack[(++j)%n] = i%n;
        }
        return result;
    }
}
