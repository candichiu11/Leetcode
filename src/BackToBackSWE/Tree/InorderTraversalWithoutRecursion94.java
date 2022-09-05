package BackToBackSWE.Tree;

import leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InorderTraversalWithoutRecursion94 {

    //Time: O(n)
    //Space: O(n)
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        TreeNode curr = root;

        while (!stack.isEmpty() || curr != null) {

            //Left
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            //Node
            curr = stack.pop();
            result.add(curr.val);

            //Right
            curr = curr.right;
        }

        return result;
    }
}
