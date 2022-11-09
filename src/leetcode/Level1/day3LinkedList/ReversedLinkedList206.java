package leetcode.Level1.day3LinkedList;

import leetcode.ListNode;

public class ReversedLinkedList206 {

    //Time: O(n), number of nodes in the list
    //Space: O(1)
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;

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
