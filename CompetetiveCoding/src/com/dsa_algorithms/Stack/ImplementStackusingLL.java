package com.dsa_algorithms.Stack;

public class ImplementStackusingLL {
    static class Node
    {
        int data;
        Node next;
        Node()
        {
            this.data = 0;
            this.next = null;
        }
        Node(int data)
        {
            this.data = data;
            this.next = null;
        }
        Node(int data, Node next)
        {
            this.data = data;
            this.next = next;
        }
    };
    static class Stack {
        //Write your code here
        Node stack;
        int size;

        Stack()
        {
            //Write your code here
        }

        int getSize()
        {
            //Write your code here
            return size;
        }

        boolean isEmpty()
        {
            //Write your code here
            return size == 0;
        }

        void push(int data)
        {
            //Write your code here
            Node node = new Node(data);
            node.next = stack;
            stack = node;
            size++;
        }

        void pop()
        {
            //Write your code here
            if (stack == null)
                return;
            stack = stack.next;
            size--;
        }

        int getTop()
        {
            //Write your code here
            return size > 0 ? stack.data : -1;
        }
    }
}
