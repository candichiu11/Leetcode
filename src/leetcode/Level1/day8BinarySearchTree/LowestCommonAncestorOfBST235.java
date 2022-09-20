package leetcode.Level1.day8BinarySearchTree;

import leetcode.TreeNode;

public class LowestCommonAncestorOfBST235 {

    //Time: O(n), Space: O(1)
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int pVal = p.val;
        int qVal = q.val;
        TreeNode node = root;

        while (node != null) {
            int parentVal = node.val;

            if(pVal > parentVal && qVal > parentVal) {
                node = node.right;
            } else if (pVal < parentVal && qVal < parentVal) {
                node = node.left;
            } else {
                return node;
            }
        }
       return null;
    }


}
