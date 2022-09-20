package BackToBackSWE.Tree;

import leetcode.Node;

public class PopulatingNextRightPointersInEachNodeII117 {

    //Time: O(n)
    //Space: O(1)
    public Node connect(Node root) {
        if (root == null) return root;

        Node head = root;
        while (head != null) {
            Node dummy = new Node();
            Node temp = dummy;

            //Build the LinkedList
            while (head != null) {
                if (head.left != null) {
                    temp.next = head.left;
                    temp = temp.next;
                }

                if (head.right != null) {
                    temp.next = head.right;
                    temp = temp.next;
                }
                head = head.next;
            }
            //Start from next level
            head = dummy.next;
        }

        return root;
    }
}
