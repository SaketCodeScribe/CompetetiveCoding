package com.dsa_algorithms.Queue;

import java.util.*;
public class QueueUsingStack {
    static class Queue {
        // Define the data members(if any) here.
        Stack<Integer> stack;
        Queue() {
            // Initialize your data structure here.
            stack = new Stack();
        }

        void enQueue(int val) {
            // Implement the enqueue() function.
            if (isEmpty()){
                stack.push(val);
                return;
            }
            int x = stack.pop();
            enQueue(val);
            stack.push(x);
        }

        int deQueue() {
            // Implement the dequeue() function.
            return isEmpty() ? -1 : stack.pop();
        }

        int peek() {
            // Implement the peek() function here.
            return isEmpty() ? -1 : stack.peek();
        }

        boolean isEmpty() {
            // Implement the isEmpty() function here.
            return stack.isEmpty();
        }
    }
}
