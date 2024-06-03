package com.dsa_algorithms.LinkedList;

public class ReverseaLL {

     static class Node{
         int data;
         Node next;
         Node(int data){
         this.data = data;
         this.next = null;
         }
     };
    public class Solution {
        public static Node reverseLL(Node head, int low, int high) {
            // Write your code here.
            if (low == high)
                return head;
            int len = 1;
            Node dummy = new Node(0);
            dummy.next = head;
            Node prev = null, curr = dummy, next = null, a = null, b = null;

            while(len < low){
                curr = curr.next;
                len++;
            }
            a = curr;
            b = curr.next;
            curr = curr.next;
            while(curr != null && len <= high){
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
                len++;
            }
            a.next = prev;
            b.next = next;
            return dummy.next;
        }
    }

}
