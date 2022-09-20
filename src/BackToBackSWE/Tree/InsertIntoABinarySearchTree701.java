package BackToBackSWE.Tree;

import leetcode.TreeNode;

public class InsertIntoABinarySearchTree701 {

    //Time: O(log n), worse case O(n)
    //Space: O(h)
    public TreeNode insertIntoBST(TreeNode root, int val) {
        //base
        if (root == null) {
            return new TreeNode(val);
        }

        if (val > root.val) {
            root.right = insertIntoBST(root.right, val);
        } else {
            root.left = insertIntoBST(root.left, val);
        }

        return root;
    }
}
