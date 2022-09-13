package BackToBackSWE.LinkedList;

import leetcode.ListNode;

public class RightShiftASinglyLinkedList61 {

    //Time: O(n)
    //Space: O(1)
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return head;
        if (k == 0) return head;

        ListNode tail = head;
        int size = 1;
        while (tail.next != null) {
            tail = tail.next;
            size++;
        }

        k %= size;

        //create the cycle
        tail.next = head;
        int stepsToNewTail = size - k;
        ListNode newTail = tail;

        while (stepsToNewTail > 0) {
            newTail = newTail.next;
            stepsToNewTail--;
        }

        ListNode newHead = newTail.next;

        //break the cycle
        newTail.next = null;

        return newHead;
    }
}
