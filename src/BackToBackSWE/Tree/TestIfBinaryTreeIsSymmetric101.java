package BackToBackSWE.Tree;

import leetcode.TreeNode;

public class TestIfBinaryTreeIsSymmetric101 {

    //Time: O(n) , upperbound, n: the number of nodes in tree
    //space: O(h) h: the height of the tree
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return helper(root.left, root.right);
    }

    private boolean helper(TreeNode leftSubTreeRoot, TreeNode rightSubTreeRoot) {
        //base case
        if (leftSubTreeRoot == null && rightSubTreeRoot == null) {
            return true;
        }

        if (leftSubTreeRoot != null && rightSubTreeRoot != null) {
            return leftSubTreeRoot.val == rightSubTreeRoot.val &&    // O(1)
                    helper(leftSubTreeRoot.left, rightSubTreeRoot.right) &&
                    helper(leftSubTreeRoot.right, rightSubTreeRoot.left);

        }
        return false;
    }
}
