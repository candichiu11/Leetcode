package BackToBackSWE.LinkedList;

import leetcode.ListNode;

public class OddEvenLinkedList328 {

    //Time: O(n), Space: O(1)
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode even = head;
        ListNode odd = head.next;
        ListNode oddHead = odd;

        while(odd != null && odd.next != null) {
            even.next = odd.next;
            even = odd.next;
            odd.next = even.next;
            odd = even.next;
        }

        even.next = oddHead;
        return head;
    }
}
