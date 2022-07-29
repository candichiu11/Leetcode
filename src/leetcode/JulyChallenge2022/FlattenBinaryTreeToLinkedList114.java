package leetcode.JulyChallenge2022;

import leetcode.TreeNode;

public class FlattenBinaryTreeToLinkedList114 {

    //Time:O(N), We process each node of the tree exactly once.
    //Space: O(h), h: height of the tree, O(h) is occupied by recursion stack for balanced tree.
    //If the tree is skewed, it would be O(N)
    public void flatten(TreeNode root) {
        if(root == null) return;

        TreeNode tempLeft = root.left;
        TreeNode tempRight = root.right;

        root.left = null;
        root.right = tempLeft;

        flatten(root.left);
        flatten(root.right);

        TreeNode current = root;
        while (current.right != null) {
            current = current.right;
        }

        current.right = tempRight;
    }
}
