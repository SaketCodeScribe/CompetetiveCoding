package com.dsa_algorithms.TwoPointer;

import java.util.Stack;

public class LC42 {
    public int trap(int[] height) {
        int i=0, n = height.length;
        int trapped = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);

        while(i<n){
            while(stack.size() > 1 && height[i] > height[stack.peek()]){
                int currInd = stack.pop();
                int prevInd = stack.peek();
                int diff = prevInd == -1 ? 0 : Math.min(height[i], height[prevInd]) - height[currInd];
                trapped += diff * (i - prevInd - 1);
            }
            stack.push(i++);
        }
        stack.clear();
        return trapped;
    }
}
