package BackToBackSWE.Tree;

import leetcode.TreeNode;

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

}
