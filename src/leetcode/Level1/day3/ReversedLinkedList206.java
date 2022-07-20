package leetcode.Level1.day3;

import leetcode.Level2.day3.RemoveNthNodeFromEndOfList19;
import leetcode.ListNode;

public class ReversedLinkedList206 {

    //Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }


    public ListNode reverseList(ListNode head) {
            ListNode previousNode = null;
            ListNode currentNode = head;

            while (currentNode!=null) {
                ListNode nextNode = currentNode.next;
                currentNode.next = previousNode;
                previousNode = currentNode;
                currentNode = nextNode;
            }
            return previousNode;
    }

}
