package com.dsa_algorithms.Stack;

import java.util.*;

public class StackUsingQueue {
    static class Stack {
        // Define the data members.
        Queue<Integer> q1;
        public Stack() {
            // Implement the Constructor.
            q1 = new LinkedList<>();
        }

        public int getSize() {
            // Implement the getSize() function.
            return q1.size();
        }

        public boolean isEmpty() {
            // Implement the isEmpty() function.
            return q1.isEmpty();
        }

        public void push(int element) {
            // Implement the push(element) function.
            int size = q1.size();
            q1.add(element);
            while(size-- > 0)
                q1.add(q1.poll());
        }

        public int pop() {
            // Implement the pop() function.
            if (isEmpty())
                return -1;
            return q1.poll();
        }

        public int top() {
            // Implement the top() function.
            if (isEmpty())
                return -1;
            return q1.peek();
        }
    }
}
