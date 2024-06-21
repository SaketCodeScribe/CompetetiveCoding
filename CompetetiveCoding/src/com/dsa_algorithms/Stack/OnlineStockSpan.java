package com.dsa_algorithms.Stack;

import java.util.*;
public class OnlineStockSpan {
    public static ArrayList<Integer> findSpans(ArrayList<Integer> price) {
        // Write your code here.
        int i = 0, n = price.size();
        Stack<Integer> stack = new Stack();
        ArrayList<Integer> ans = new ArrayList();
        stack.push(-1);

        while(i < n){
            while(stack.size() > 1 && price.get(i) >= price.get(stack.peek()))
                stack.pop();
            ans.add(i-stack.peek());
            stack.push(i++);
        }
        return ans;
    }
}
