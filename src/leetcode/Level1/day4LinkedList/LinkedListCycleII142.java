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
}
