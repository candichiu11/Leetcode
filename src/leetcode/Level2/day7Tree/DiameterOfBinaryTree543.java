package leetcode.Level2.day7Tree;

import leetcode.TreeNode;

public class DiameterOfBinaryTree543 {

     //Time: O(n), Space: O(n),
     // The space complexity depends on the size of our implicit call stack during our DFS,
     // which relates to the height of the tree. In the worst case,
     // the tree is skewed so the height of the tree is O(N)
     int max = 0;
     public int diameterOfBinaryTree(TreeNode root) {
           height(root);
           return max;
     }

     private int height(TreeNode root) {
          if(root == null) return 0;

          int leftH = height(root.left);
          int rightH = height(root.right);
          max = Math.max(max, leftH + rightH);

          return Math.max(leftH, rightH) +1;

     }




}
