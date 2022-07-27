package leetcode.Level2.day9BinarySearchTree;

import leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

//173
public class BSTIterator {

    List<Integer> nodesSorted = new ArrayList<>();
    int index = 0;
    //Time: O(n)
    //Space: O(n), we create a new array to contain all the nodes in BST.
    public BSTIterator(TreeNode root) {
        inOrder(root);
    }

    private void inOrder(TreeNode root) {
        if(root==null) return;

        inOrder(root.left);
        nodesSorted.add(root.val);
        inOrder(root.right);
    }

    //Time: O(1), Space: O(n)
    public int next() {
        return nodesSorted.get(index++);
    }

    //Time:O(1), Space: O(n)
    public boolean hasNext() {
       return index < nodesSorted.size();
    }
}
