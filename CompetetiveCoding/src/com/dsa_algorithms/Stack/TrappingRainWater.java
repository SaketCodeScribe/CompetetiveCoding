package com.dsa_algorithms.Stack;

import java.util.*;
import java.util.stream.Collectors;

public class TrappingRainWater {
    public int trap(int[] height) {
        int i = 0, n = height.length, ans = 0, base, ht, ind;
        Stack<Integer> stack = new Stack<>();

        while(i < n){
            while(!stack.isEmpty() && height[i] >= height[stack.peek()]){
                ind = stack.pop();
                if (stack.isEmpty())
                    break;
                ht = Math.min(height[i], height[stack.peek()])-height[ind];
                base = i - stack.peek() - 1;
                ans += base*ht;
            }
            stack.push(i++);
        }
        return ans;
    }
}
