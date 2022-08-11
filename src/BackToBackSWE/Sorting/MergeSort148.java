package BackToBackSWE.Sorting;

import leetcode.ListNode;

public class MergeSort148 {

    //Time: O(nlog n), n: number of nodes in the list
    //Space: O(1)
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode mid = getMiddleNode(head);
        ListNode leftSorted = sortList(head);
        ListNode rightSorted = sortList(mid);

        return merge(leftSorted, rightSorted);
    }

    private ListNode getMiddleNode(ListNode head) {
        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = null;
        return slow;
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode dummyEnd = dummyHead;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                dummyEnd.next = l1;
                l1 = l1.next;
            } else {
                dummyEnd.next = l2;
                l2 = l2.next;
            }
            dummyEnd =dummyEnd.next;
        }

        if (l1 != null) {
           dummyEnd.next = l1;
        }

        if(l2 != null) {
            dummyEnd.next = l2;
        }

        return dummyHead.next;

    }

}
