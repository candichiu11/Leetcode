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


}
