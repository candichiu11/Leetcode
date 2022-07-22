package leetcode.Level2.day4LinkedList;

import leetcode.ListNode;

public class OddEvenLinkedList328 {

    //Time: O(n), Space: O(1)
    public ListNode oddEvenList(ListNode head) {

        if(head == null) return null;

        ListNode odd = head, even = head.next, evenHead = even;

        while(even != null && even.next !=null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }

        odd.next = evenHead;

        return head;
    }




}
