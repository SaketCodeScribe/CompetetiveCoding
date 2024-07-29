package com.dsa_algorithms.LinkedList;

public class ReverseLinkedListII {
    static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) {
          this.val = val; this.next = next;
      }
  }
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode curr = head, prev = null, next, temp, temp1;
        int i = 1;
        while(curr != null && i < left){
            prev = curr;
            curr = curr.next;
            i++;
        }
        temp = next = null;
        temp1 = curr;

        while(curr != null && i <= right){
            next = curr.next;
            curr.next = temp;
            temp = curr;
            curr = next;
            i++;
        }
        if (prev != null)
            prev.next = temp;
        else
            head = temp;
        temp1.next = next;
        return head;
    }
}
