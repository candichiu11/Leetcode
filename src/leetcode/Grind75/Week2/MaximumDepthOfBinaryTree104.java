package leetcode.Grind75.Week2;

import leetcode.TreeNode;

public class MaximumDepthOfBinaryTree104 {

    //Time: O(n), n : number of nodes in tree
    //Space: O(h), h the height of the tree, worst case: O(n)
    public int maxDepth(TreeNode root) {
        return depth(root);
    }

    private int depth(TreeNode root) {
        if (root == null) return 0;
        int leftDepth = depth(root.left);
        int rightDepth = depth(root.right);

        return Math.max(leftDepth, rightDepth) + 1;
    }
}
