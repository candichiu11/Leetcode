package leetcode.NeetCode150.LinkedList;

import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointer138 {

    // Definition for a Node.
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    // Time: O(n)
    // Space: O(n), map
    public Node copyRandomList(Node head) {
        if (head == null) return head;

        Map<Node, Node> map = new HashMap<>();

        Node curr = head;
        map.put(curr, new Node(curr.val));

        while (curr != null) {

            Node currCopy = map.get(curr);

            if (curr.next != null && !map.containsKey(curr.next)) {
                map.put(curr.next, new Node(curr.next.val));
            }

            Node nextCopy = map.get(curr.next);
            currCopy.next = nextCopy;

            if (curr.random != null && !map.containsKey(curr.random)) {
                map.put(curr.random, new Node(curr.random.val));
            }

            Node randomCopy = map.get(curr.random);
            currCopy.random = randomCopy;

            curr = curr.next;

        }

        return map.get(head);
    }
}
