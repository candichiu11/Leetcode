package leetcode.Level1.day3LinkedList;

public class ReversedLinkedList206 {

    //Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    //Time: O(n)
    //Space: O(1)
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
