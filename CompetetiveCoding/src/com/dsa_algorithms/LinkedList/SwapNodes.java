package com.dsa_algorithms.LinkedList;

public class SwapNodes {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    public static Node pairsSwap(Node head) {
        // Write your code here.
        if (head == null || head.next == null)
            return head;
        Node ans = new Node(0), prev, next;
        prev = ans;
        prev.next = head;

        while(head != null && head.next != null){
            next = head.next.next;
            prev.next = swap(head, head.next);
            prev = head;
            head = next;
        }
        prev.next = head;
        return ans.next;
    }
    public static Node swap(Node a, Node b){
        b.next = a;
        a.next = null;
        return b;
    }
}
