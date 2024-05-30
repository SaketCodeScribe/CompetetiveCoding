package com.dsa_algorithms.LinkedList;

public class DeleteKthNode {
    static class Node {
        public int data;
        public Node next;
        public Node prev;

        Node()
        {
            this.data = 0;
            this.next = null;
            this.prev = null;
        }

        Node(int data)
        {
            this.data = data;
            this.next = null;
            this.prev = null;
        }

        Node(int data, Node next)
        {
            this.data = data;
            this.next = next;
            this.prev = next;
        }
    }
    public static Node removeKthNode(Node head, int K)
    {
        Node ptr1 = head, ptr2 = head;

        while(ptr2 != null && K-- > 0)
            ptr2 = ptr2.next;
        if (ptr2 == null)
            return ptr1.next;
        while (ptr1 != null && ptr2.next != null){
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }
        ptr1.next = ptr1.next.next;
        return head;
    }
}
