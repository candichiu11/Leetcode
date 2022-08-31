package BackToBackSWE.Tree;

import leetcode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class TestIfBinaryTreeIsSymmetricIterative101 {

    //Using iterative because recursion might cause stack overflow when there are a lot of nodes.
    //Time: O(n), n: number of nodes in tree
    //Space: O(n)
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;

        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();

        q1.offer(root.left);
        q2.offer(root.right);

        while (!q1.isEmpty() && !q2.isEmpty()) {
            TreeNode n1 = q1.poll();
            TreeNode n2 = q2.poll();

            if ((n1 == null && n2!= null) || (n1 != null && n2 == null)) {
                return false;
            }

            if (n1 != null) {
                if (n1.val != n2.val) {
                    return false;
                }

                q1.offer(n1.left);
                q1.offer(n1.right);
                q2.offer(n2.right);
                q2.offer(n2.left);
            }
        }
        return true;
    }
}
