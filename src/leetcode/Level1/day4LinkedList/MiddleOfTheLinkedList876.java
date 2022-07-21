package leetcode.Level1.day4LinkedList;

import leetcode.ListNode;

public class MiddleOfTheLinkedList876 {

    //Time: O(n), Space: O(1)
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        System.out.println(slow.val);
        return slow;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode ele =  new ListNode(2);
        ListNode ele2 = new ListNode(3);
        ListNode ele3 = new ListNode(4);
        ListNode ele4 = new ListNode(5);
        ListNode ele5 = new ListNode(6);

        head.next = ele;
        ele.next = ele2;
        ele2.next = ele3;
        ele3.next = ele4;
        ele4.next = ele5;

        MiddleOfTheLinkedList876 test = new MiddleOfTheLinkedList876();
        test.middleNode(head);

    }

}
