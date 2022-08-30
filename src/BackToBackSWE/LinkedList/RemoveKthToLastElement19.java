package BackToBackSWE.LinkedList;

import leetcode.ListNode;

public class RemoveKthToLastElement19 {

    //Time: O(n)
    //Space: O(1)
    public ListNode removeKthToLast(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode right = head;
        ListNode left = dummy;

        while (k > 0) {
            right = right.next;
            k--;
        }

        while (right != null) {
            left = left.next;
            right = right.next;
        }

        left.next = left.next.next;

        return dummy.next;
    }
}
