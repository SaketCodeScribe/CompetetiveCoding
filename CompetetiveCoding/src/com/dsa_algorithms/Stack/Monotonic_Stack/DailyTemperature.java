package com.dsa_algorithms.Stack.Monotonic_Stack;

import java.util.*;

public class DailyTemperature {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length, i, id;
        int[] ans = new int[n];
        Stack<Integer> stack = new Stack<>();

        for(i=0; i<n; i++){
            while(!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]){
                id = stack.pop();
                ans[id] = i-id;
            }
            stack.add(i);
        }
        return ans;
    }
}
