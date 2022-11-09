package leetcode.Grind75.Week1;

import leetcode.ListNode;

import java.util.HashSet;
import java.util.Set;

public class LinkedListCycle141 {

    //Time: O(n), n: number of nodes
    //Space: O(n)
    public boolean hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        ListNode curr = head;

        while (curr != null) {

            if (!set.add(curr)) {
                return true;
            }

            curr = curr.next;
        }
        return false;
    }

    // Time: O(n)
    // Space: O(1)
    public boolean hasCycleConstantSpace(ListNode head) {
        if (head == null || head.next == null) return false;

        ListNode slow = head, fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }

        return false;
    }
}
