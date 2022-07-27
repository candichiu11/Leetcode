package leetcode.Level2.day9BinarySearchTree;

import leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class KthSmallestElementInBST230 {

    //Time: O(n), to build a traversal
    //Space: O(n), a new array to store inorder traversal
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> ascendingArray = new ArrayList<>();
        return inOrder(root, ascendingArray).get(k-1);
    }

    private List<Integer> inOrder(TreeNode root, List<Integer> result) {
        inOrder(root.left, result);
        result.add(root.val);
        inOrder(root.right, result);
        return result;
    }
}
