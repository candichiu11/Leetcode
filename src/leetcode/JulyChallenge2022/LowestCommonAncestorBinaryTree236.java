package leetcode.JulyChallenge2022;

import leetcode.TreeNode;


public class LowestCommonAncestorBinaryTree236 {

    //Time: O(N), Space: O(N) N: the number of nodes in the binary tree
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
          if(root == null) return null;

          if(root.equals(p) || root.equals(q)) return root;

          TreeNode left = lowestCommonAncestor(root.left, p, q);
          TreeNode right = lowestCommonAncestor(root.right, p, q);

          if(left != null && right != null) return root;
          return left == null? right : left;
    }
}
