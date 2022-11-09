package leetcode.NeetCode150.Trees;

import leetcode.TreeNode;

public class CountGoodNodesInBinaryTree1448 {

    // Time: O(N)
    // Space: O(N)
    public int goodNodes(TreeNode root) {
       if (root == null) return 0;
       return dfs(root, root.val);

    }

    private int dfs(TreeNode root, int max) {
        //base
        if (root == null) return 0;

        max = Math.max(max, root.val);
        if (root.val >= max) {
            return 1 + dfs(root.left, max) + dfs(root.right, max);
        } else {
            return dfs(root.left, max) + dfs(root.right, max);
        }

    }
}
