package leetcode.Level2.day6Tree;

import com.sun.source.tree.Tree;
import leetcode.TreeNode;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InvertBinaryTree226 {

      //Time: O(n), n: number of nodes,  Space: O(h), h: the height of the tree
      public TreeNode invertTree(TreeNode root) {
       //recursion
          if(root == null) { return root;}

          TreeNode left = invertTree(root.left);
          TreeNode right = invertTree(root.right);

          root.left = right;
          root.right = left;

          return root;

      }

      public static void main(String[] args) {
          InvertBinaryTree226 test = new InvertBinaryTree226();
          TreeNode root = new TreeNode(4);
          TreeNode left = new TreeNode(2);
          TreeNode right = new TreeNode(7);
          root.left = left;
          root.right = right;

          test.invertTree(root);
      }


}
