package com.dsa_algorithms.LinkedList;

public class RearangeLinkedList {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    public static Node rearrangeList(Node head)
    {
        // Write your code here.
        if (head == null)
            return head;
        Node ans = head;
        Node mid = findMid(head);
        Node curr = mid.next;
        mid.next = null;
        curr = reverse(curr);

        while(curr != null && head != null){
            Node next = head.next, next2 = curr.next;
            head.next = curr;
            curr.next = next;
            curr = next2;
            head = next;
        }
        return ans;
    }
    public static Node findMid(Node curr){
        Node slow = curr, fast = curr.next;

        while(slow != null && fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public static Node reverse(Node curr){
        Node prev = null, next;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
