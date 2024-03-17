package com.dsa_algorithms.Stack;

import java.util.Stack;

public class LargestRectangleinHistogram {
    public static int largestRectangleArea(int[] heights) {
        int i = 0, n = heights.length, area = 0;
        Stack<Integer> stack = new Stack<>();

        while(i < n){
            while(!stack.isEmpty() && heights[stack.peek()] > heights[i]){
                int ind = stack.pop();
                area = Math.max(area, (i-(stack.isEmpty() ? -1 : stack.peek())-1)*heights[ind]);
            }
            stack.push(i++);
        }
        while(!stack.isEmpty()){
            int ind = stack.pop();
            area = Math.max(area, (n-(stack.isEmpty() ? -1 : stack.peek())-1)*heights[ind]);
        }
        return area;
    }

    public static void main(String[] args) {
        System.out.println(LargestRectangleinHistogram.largestRectangleArea(new int[]{2,1,5,6,2,3}));
        System.out.println(LargestRectangleinHistogram.largestRectangleArea(new int[]{2,4}));
        System.out.println(LargestRectangleinHistogram.largestRectangleArea(new int[]{1,2,3,4,5,6}));
        System.out.println(LargestRectangleinHistogram.largestRectangleArea(new int[]{6,5,4,3,2,1}));

    }
}
