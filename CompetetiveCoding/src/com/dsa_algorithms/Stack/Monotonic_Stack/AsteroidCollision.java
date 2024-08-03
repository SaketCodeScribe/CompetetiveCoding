package com.dsa_algorithms.Stack.Monotonic_Stack;

import java.util.Stack;

public class AsteroidCollision {
    /*
        Time: O(n)
        Space: O(n)
     */
    public int[] asteroidCollision(int[] asteroids) {
        int i, n = asteroids.length;
        Stack<Integer> stack = new Stack<>();
        int[] ans;

        for(i=0; i<n; i++){
            boolean flag = true;
            while(!stack.isEmpty() && stack.peek() > 0 && asteroids[i] < 0){
                if (Math.abs(stack.peek()) >= Math.abs(asteroids[i])){
                    flag = false;
                    if (Math.abs(stack.peek()) == Math.abs(asteroids[i]))
                        stack.pop();
                    break;
                }
                stack.pop();
            }
            if (flag)
                stack.push(asteroids[i]);
        }
        ans = new int[stack.size()];
        i = stack.size()-1;
        while(!stack.isEmpty()){
            ans[i--] = stack.pop();
        }
        return ans;
    }
}
