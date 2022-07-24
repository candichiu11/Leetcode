package leetcode.Level2.day6Tree;

import leetcode.TreeNode;

public class BalancedBinaryTree110 {

    //Top-down recursion
    //Time: O(n^2), Space: O(n), the recursion stack may contain all nodes if the tree is skewed.
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
         if(Math.abs(height(root.left) - height(root.right)) > 1) return false;
         return isBalanced(root.right) && isBalanced(root.left);
    }

    //Time: O(n)
    private int height(TreeNode root) {
        if(root == null) return -1;
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        return Math.max(leftHeight, rightHeight) + 1 ;
    }

    boolean passed = true;
    //buttom-up
    //Time: O(n), Space: O(n)
    public boolean isBalancedButtonUp(TreeNode root) {
        if(root == null) return true;
        heightButtonUp(root);
        return passed;
    }

    private int heightButtonUp(TreeNode root) {
        if(root == null) return -1;
        int leftHeight = heightButtonUp(root.left) + 1;
        int rightHeight = heightButtonUp(root.right) + 1;
        int balanceFactor = Math.abs(leftHeight - rightHeight);
        if(balanceFactor>1) {
            passed = false;
        }
        return Math.max(leftHeight, rightHeight);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode left = new TreeNode(9);
        TreeNode right = new TreeNode(20);
        TreeNode left2 = new TreeNode(15);
        TreeNode right2 = new TreeNode(7);
        TreeNode left3 = new TreeNode(8);
        TreeNode right3 = new TreeNode(9);

        root.left = left;
        root.right = right;
        right.left = left2;
        right.right = right2;
        left2.left = left3;
        left2.right = right3;
        BalancedBinaryTree110 test = new BalancedBinaryTree110();
        test.isBalanced(root);
    }

}
