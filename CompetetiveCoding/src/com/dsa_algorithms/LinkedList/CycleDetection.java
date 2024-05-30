package com.dsa_algorithms.LinkedList;

public class CycleDetection {
    static class Node{
        int data;
        Node next;
    }
    public static boolean detectCycle(Node head) {

        if (head == null || head.next == null) {
            return false;
        }

        //  Slow Pointer - This will be incremented by 1 Nodes.
        Node slow = head;
        //  Fast Pointer  - This will be incremented by 2 Nodes.
        Node fast = head.next;

        while (slow != fast) {

            //  We reached the end of the List and haven't found any Cycle.
            if (fast == null || fast.next == null) {
                return false;
            }

            slow = slow.next;
            fast = fast.next.next;
        }
        //  We found a Cycle.
        return true;

    }
}
