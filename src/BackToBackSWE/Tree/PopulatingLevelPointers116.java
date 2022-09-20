package BackToBackSWE.Tree;


import leetcode.Node;

public class PopulatingLevelPointers116 {

    //Time: O(n)
    //Space: O(h)
    public Node connect(Node root) {
          if (root == null) return null;

          if (root.left != null) {
              root.left.next = root.right;
          }

          if (root.right != null && root.next != null) {
              root.right.next = root.next.left;
          }

          root.left = connect(root.left);
          root.right = connect(root.right);

          return root;

      }
}
