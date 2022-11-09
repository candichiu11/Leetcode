package leetcode.NeetCode150.Trees;

import leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeRightSideView199 {

    // Time: O(N)
    // Space: O(N), best case: O(H)
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        dfs(root, 0, result);
        return result;
    }

    private void dfs(TreeNode root, int level, List<Integer> result) {
        if (root == null) return;

        if (result.size() == level) {
            result.add(root.val);
        }

        dfs(root.right, level + 1, result);
        dfs(root.left, level + 1, result);

    }

}
