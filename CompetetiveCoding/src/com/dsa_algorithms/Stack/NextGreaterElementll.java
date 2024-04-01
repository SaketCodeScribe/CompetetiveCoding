package com.dsa_algorithms.Stack;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElementll {
    public static int[] nextGreaterElementII(int []a) {
        int i = 0, n = a.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        Stack<Integer> stack = new Stack<>();
        for(i=0; i<n; i++)
            stack.add(i);
        i = 0;
        while (i<n){
            while(!stack.empty() && a[stack.peek()] < a[i]){
                int ind = stack.pop();
                ans[ind] = a[i];
            }
            stack.push(i++);
        }
        return ans;
    }

    public static void main(String[] args) {
        Arrays.stream(nextGreaterElementII(new int[]{1,5,3,4,2})).forEach(value -> System.out.print(value+" "));
    }
}
