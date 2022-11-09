package leetcode.Level1.day4LinkedList;

import java.util.HashSet;
import java.util.Set;

public class LinkedListCycleII142 {

    //Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void main ( String [ ] args ) {
       ListNode head = new ListNode(3);
       ListNode ele = new ListNode(2);
       ListNode ele2 = new ListNode(0);
       ListNode ele3 = new ListNode(-4);

       head.next = ele;
       ele.next = ele2;
       ele2.next = ele3;
       ele3.next = ele;

       LinkedListCycleII142 test= new LinkedListCycleII142();
       test.detectCycle(head);
    }


    //Time: O(n), Space: O(n)
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> visited = new HashSet<>();
        ListNode node = head;

        while(node != null) {
            if(visited.contains(node)){
                return node;
            }

            visited.add(node);
            node = node.next;
        }
        return null;

    }

    //Floyd's cycle finding algorithm
    // Time: O(n)
    // Space: O(1)
    public ListNode detectCycleFloyds(ListNode head) {
        if (head == null || head.next == null) return null;

        ListNode slow = head, fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                fast = head;
                break;
            }
        }

        if (fast == head) {
            while (slow != fast) {
                if (slow != null && fast != null) {
                    slow = slow.next;
                    fast = fast.next;
                }

            }

            if (slow == fast) {
                return slow;
            }

        }

        return null;

    }
}
