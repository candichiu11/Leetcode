package leetcode.NeetCode150.Trees;

import leetcode.TreeNode;

public class SubtreeOfAnotherTree572 {

    // Time: O(N * M), N: total number of nodes in root, M: total number of nodes in subRoot
    /*
    For every N node in the tree, we check if the tree rooted at node is identical to subRoot.
    This check takes O(M) time.
     */
    // Space: O(N + M) There will be at most N recursive calls to dfs ( or isSubtree).
    // Now, each of these calls will have M recursive calls to isSameTree.
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (subRoot == null) return true;
        if (root == null && subRoot != null) return false;
        if (isSameTree(root, subRoot)) {
            return true;
        }

        return isSubtree(root.left, subRoot) ||
                isSubtree(root.right, subRoot);
    }

    private boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }

        if (p == null || q == null) {
            return false;
        }

        if (p != null && q != null && p.val != q.val) {
            return false;
        }

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
