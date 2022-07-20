package leetcode.Level2.day3;

import leetcode.Level1.day4.LinkedListCycleII142;

public class RemoveNthNodeFromEndOfList19 {


    //Definition for singly-linked list.
    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    //Time: O(n), Space: O(1)
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;

        while(fast.next != null) {
            fast = fast.next;
            if(n-- <=0) {
                slow=slow.next;
            }
        }

        slow.next = slow.next.next;
        return dummy.next;
    }

    public void getLengthOfLinkedList(ListNode head) {
        int length = 0;
        ListNode currentNode = head;
        while (currentNode != null) {
            currentNode = currentNode.next;
            length +=1;
        }
        System.out.println(length);
    }

    public static void main ( String [ ] args ) {
        ListNode head = new ListNode(1);
        ListNode ele =  new ListNode(2);
        ListNode ele2 = new ListNode(3);
        ListNode ele3 = new ListNode(4);
        ListNode ele4 = new ListNode(4);

        head.next = ele;
        ele.next = ele2;
        ele2.next = ele3;
        ele3.next = ele4;

        RemoveNthNodeFromEndOfList19 test = new RemoveNthNodeFromEndOfList19();
        test.removeNthFromEnd(head, 2);
    }
}
