package BackToBackSWE.Tree;

import leetcode.TreeNode;

import java.util.Stack;

public class TestATreeForTheBSTProperty98 {

      //Time: O(n), n: number of nodes in tree
      //Space: O(n), we keep up the entire tree
      public boolean isValidBST(TreeNode root) {
         return checkTree(root, Long.MIN_VALUE, Long.MAX_VALUE);

      }

      private boolean checkTree(TreeNode root, long low, long high) {
        if (root == null) {
            return true;
        } else if (root.val <= low || root.val >= high) {
            return false;
        }

        return checkTree(root.left, low, root.val) && checkTree(root.right, root.val, high);

      }

      // Inorder: left node right
      // Inorder traversal check if vals are in ascending order
      // Iterative to avoid stack overflow, if the tree not balanced
      // Time: O(n), n: total number of nodes
      // Space: O(n)
      public boolean isValidBSTIterative(TreeNode root) {
          if (root == null) return true;

          Stack<TreeNode> stack = new Stack<>();
          TreeNode curr = root;
          long prev = Long.MIN_VALUE;

          while (!stack.isEmpty() || curr != null) {
              while (curr != null) {
                  stack.add(curr);
                  curr = curr.left;
              }

              curr = stack.pop();
              if (prev >= curr.val) {
                  return false;
              }
              prev = curr.val;
              curr = curr.right;
          }

          return true;
      }

}
