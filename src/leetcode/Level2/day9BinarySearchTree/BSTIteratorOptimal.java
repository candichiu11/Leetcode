package leetcode.Level2.day9BinarySearchTree;

import leetcode.TreeNode;

import java.util.Stack;

public class BSTIteratorOptimal {

    Stack<TreeNode> stack = new Stack<>();

    public BSTIteratorOptimal(TreeNode root) {
        partialInOrder(root);
    }

    private void partialInOrder(TreeNode root) {
        while(root != null) {
            stack.push(root);
            root = root.left;
        }
    }

    //Time: O(N)
    //Space: O(H), H: height of the tree , worst case if the tree is skewed O(N)
    public int next(){
        TreeNode top = stack.pop();
        partialInOrder(top.right);
        return top.val;
    }

    //Time: O(1)
    public boolean hasNext() {
       return !stack.isEmpty();
    }

}
