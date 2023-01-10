package leetcode.NeetCode150.LinkedList;

import leetcode.ListNode;

public class ReverseNodesInKGroup25 {

    // Time: O(n * k)
    // Space: O(1)
    public ListNode reverseKGroup(ListNode head, int k) {
         ListNode dummy = new ListNode(0);
         dummy.next = head;
         ListNode prev = dummy;
         ListNode curr = head;

         // O(n)
         while (curr != null) {
             ListNode tail = curr;
             int index = 0;

             while (curr != null && index < k) {
                 curr = curr.next;
                 index++;
             }

             if (index == k) {
                 prev.next = reverse(tail, k);
                 prev = tail;
             } else {
                 prev.next = tail;
             }
         }
        return dummy.next;

    }

    //O(k)
    private ListNode reverse(ListNode head, int k) {
        ListNode prev = null;
        ListNode next = null;
        ListNode curr = head;

        while (curr != null && k != 0) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            k--;
        }
        return prev;
    }
}
