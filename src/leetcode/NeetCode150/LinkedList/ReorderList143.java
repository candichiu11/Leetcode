package leetcode.NeetCode150.LinkedList;

import leetcode.ListNode;

public class ReorderList143 {

    // Time: O(N)
    // Space: O(1)
    public void reorderList(ListNode head) {
         if (head == null || head.next == null) {
             return;
         }

         //O(N)
         ListNode slow = head, fast = head, pre = null;
         while (fast != null && fast.next != null) {
             pre = slow;
             slow = slow.next;
             fast = fast.next.next;
         }

         //break the link
         pre.next = null;

         ListNode tail = reverseList(slow); //O(N/2)
         ListNode curr = head;

        //O(N)
         while (curr != null && tail != null) {
              ListNode currNext = curr.next;
              ListNode tailNext = tail.next;

              curr.next = tail;
              tail.next = currNext == null ? tailNext : currNext;
              curr = currNext;
              tail = tailNext;
         }

    }

    private ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }



}
