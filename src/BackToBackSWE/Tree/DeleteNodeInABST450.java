package BackToBackSWE.Tree;

import leetcode.TreeNode;

public class DeleteNodeInABST450 {

    //Time: O(log n) or O(h), n: number of nodes in BST
    //Space: O(h)
    public TreeNode deleteNode(TreeNode root, int key) {
        //base
        if (root == null) {
            return null;
        }

        if (key > root.val) {
            root.right = deleteNode(root.right, key);

        } else if (key < root.val) {
            root.left = deleteNode(root.left, key);

        } else {
            /*
             * We have found the node that needs to be removed, we have 3 cases:
             *
             * 1.) Empty left subtree: We can just return the right subtree of the node,
             * cutting root itself out
             *
             * 2.) Empty right subtree: We can just return the left subtree of the node,
             * cutting root itself out
             *
             * 3.) Non-empty left and right subtrees: We want the next node in the inorder
             * traversal after this node to take this node's place.
             *
             * Hop to the right and go all the way left to get the next item in the inorder
             * traversal.
             */

            if (root.left == null) {
                return root.right;

            } else if (root.right == null) {
                return root.left;

            } else {
                TreeNode next = getNextInorderNode(root.right);
                root.val = next.val;

                /*
                 * Now update root's right subtree by removing the actual 'nextInorderNode'
                 * object from it sine we just placed its value into root
                 */
                root.right = deleteNode(root.right, next.val);
            }
        }
       return root;
    }

    private TreeNode getNextInorderNode(TreeNode root) {
        if (root == null) return null;
        TreeNode curr = root;

        while (curr.left != null) {
            curr = curr.left;
        }

        return curr;
    }
}
