package leetcode.NeetCode150.Trees;

import leetcode.TreeNode;

public class SameTree100 {

    // Time: O(n)
    // Space: O(n)
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;

        if (p != null && q != null && p.val != q.val) {
            return false;
        }

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
