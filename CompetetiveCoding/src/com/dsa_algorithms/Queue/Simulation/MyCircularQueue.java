package com.dsa_algorithms.Queue.Simulation;

public class MyCircularQueue {
    static class Node{
        int data;
        Node next;
        Node(int val){
            data = val;
        }
    }

    Node head, tail;
    int size, n;
    public MyCircularQueue(int k) {
        size = k;
    }

    public boolean enQueue(int value) {
        if (n == size)
            return false;
        if (head == null){
            head = tail = new Node(value);
            n++;
        }
        else if (n < size){
            tail.next = new Node(value);
            tail = tail.next;
            n++;
        }
        return true;
    }

    public boolean deQueue() {
        if (n == 0)
            return false;
        head = head.next;
        if (head == null)
            tail = null;
        n--;
        return true;
    }

    public int Front() {
        if (n == 0)
            return -1;
        return head.data;
    }

    public int Rear() {
        if (n == 0)
            return -1;
        return tail.data;
    }

    public boolean isEmpty() {
        return n==0;
    }

    public boolean isFull() {
        return n==size;
    }
}
