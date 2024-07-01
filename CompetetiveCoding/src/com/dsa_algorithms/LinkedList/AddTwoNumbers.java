package com.dsa_algorithms.LinkedList;

public class AddTwoNumbers {
    static public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        if (length(l2) > length(l1))
            return addTwoNumbers(l2, l1);
        int carry = 0, val;
        ListNode head1 = l1, head2 = l2;

        while(head1 != null){
            if (head2 == null){
                val = head1.val+carry;
                carry = val/10;
                head1.val = val%10;
            }
            else{
                val = head1.val+head2.val+carry;
                carry = val/10;
                head1.val = val%10;
                head2 = head2.next;
            }
            if (head1.next == null && carry > 0){
                head1.next = new ListNode(carry);
                head1 = head1.next;
            }
            head1 = head1.next;
        }
        return l1;
    }
    public int length(ListNode head){
        ListNode slow = head, fast = head.next;
        int len = 0;

        while(slow != null && fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            len++;
        }
        return 2*len+(fast != null ? 1 : 0);
    }
}
