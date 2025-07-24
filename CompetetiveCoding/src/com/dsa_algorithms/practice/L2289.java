package com.dsa_algorithms.practice;

import java.util.Stack;

public class L2289 {
    static class Element {
        int num, steps;

        public Element(int num, int cnt) {
            this.num = num;
            this.steps = cnt;
        }

    }

    public int totalSteps(int[] nums) {
        int n = nums.length, i = n - 1, ans = 0;
        Stack<Element> stack = new Stack<>();

        while (i >= 0) {
            int steps = 0;
            while (!stack.isEmpty() && nums[i] > stack.peek().num) {
                if (steps >= stack.peek().steps) {
                    steps++;
                } else {
                    steps = Math.max(steps, stack.peek().steps);
                }
                stack.pop();
            }
            stack.push(new Element(nums[i], steps));
            ans = Math.max(ans, steps);
            i--;
        }
        return ans;
    }
}
