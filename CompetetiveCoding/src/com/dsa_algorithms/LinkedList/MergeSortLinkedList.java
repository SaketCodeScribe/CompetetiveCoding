package com.dsa_algorithms.LinkedList;

public class MergeSortLinkedList {
    static class Node{
        public int data;
        public Node next;

        Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    public static Node sortLL(Node head){
        // Write your code here.
        if (head == null || head.next == null)
            return head;
        Node slow = head, fast = head.next;

        while(slow != null && fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        Node mid = slow.next;
        slow.next = null;
        Node a = sortLL(head);
        Node b = sortLL(mid);
        return merge(a, b);
    }
    public static Node merge(Node a, Node b){
        if (a == null)
            return b;
        if (b == null)
            return a;

        Node ans = null, curr = null;
        while(a != null && b != null){
            if (a.data <= b.data){
                if (ans == null)
                    ans = curr = a;
                else{
                    curr.next = a;
                    curr = curr.next;
                }
                a = a.next;
            }
            else{
                if (ans == null)
                    ans = curr = b;
                else{
                    curr.next = b;
                    curr = curr.next;
                }
                b = b.next;
            }
            curr.next = null;
        }
        curr.next = a != null ? a : (b!= null ? b : null);
        return ans;
    }
}
