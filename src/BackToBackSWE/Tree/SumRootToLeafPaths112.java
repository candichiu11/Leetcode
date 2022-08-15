package BackToBackSWE.Tree;

import leetcode.TreeNode;

public class SumRootToLeafPaths112 {

    //Time: O(n), n: number of node in the tree
    //Space: O(h), h: height of the tree
    public boolean hasPathSum(TreeNode node, int targetSum) {
        if (node == null) return false;

        boolean isLeaf = node.left == null && node.right == null;

        //base case
        //O(1)
        if (isLeaf && targetSum - node.val == 0) {
            return true;
        }

        return hasPathSum(node.left, targetSum - node.val) ||
                hasPathSum(node.right, targetSum - node.val);
    }
}
