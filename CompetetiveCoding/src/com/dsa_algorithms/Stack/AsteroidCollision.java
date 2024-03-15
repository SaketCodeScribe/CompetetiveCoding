package com.dsa_algorithms.Stack;

import java.util.Stack;

public class AsteroidCollision {
    /*
        Time: O(n)
        Space: O(n)
     */
    public int[] asteroidCollision(int[] asteroids) {
        int i = 0, n = asteroids.length;
        Stack<Integer> stack = new Stack<Integer>();

        while(i<n){
            while(!stack.empty() && asteroids[i] < 0 && stack.peek() < -1*asteroids[i]){
                stack.pop();
            }
            if (asteroids[i] < 0 && stack.peek() == -1*asteroids[i])
                stack.pop();
            else if (asteroids[i] > 0)
                stack.push(asteroids[i]);
            else if (stack.isEmpty() || stack.peek() < 0)
                stack.push(asteroids[i]);
            i++;
        }
        return stack.stream().mapToInt(Integer::intValue).toArray();
    }
}
