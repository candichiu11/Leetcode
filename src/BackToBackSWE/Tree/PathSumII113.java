package BackToBackSWE.Tree;

import leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PathSumII113 {

    //Time: O(n^2) if the tree is a complete binary tree
    /*
    For every leaf, we perform a potential O(N) operation of
    copying over the pathNodes nodes to a new list to be added to the final pathsList.
    Hence, the complexity in the worst case could be O(N^2)
     */

    //Space: O(n) , if we don't consider the output space (result list), only consider partialResult
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) return new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();

        helper(root, targetSum, new ArrayList<>(), result);
        return result;


    }

    private void helper(TreeNode root, int target, List<Integer> partialResult,List<List<Integer>> result) {
        boolean isLeaf = root.left == null && root.right == null;

        if (root == null) return;

        partialResult.add(root.val);
        if (isLeaf && target - root.val == 0) {
            result.add(new ArrayList<>(partialResult));
            return;
        }

        helper(root.left, target - root.val, new ArrayList<>(partialResult), result);
        helper(root.right, target - root.val, new ArrayList<>(partialResult), result);

    }
}
