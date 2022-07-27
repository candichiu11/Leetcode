package leetcode.Level2.day9BinarySearchTree;

import leetcode.TreeNode;

public class ConvertSortedArrayToBinarySearchTree108 {

    //Time: O(n), we visited each node exactly once.
    //Space: O(log n), The recursion stack requires O(log n) space because the tree is height balanced.
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length-1);
    }

    private TreeNode helper(int[] nums, int start, int end) {
        if(start > end) return null;

        int mid = start + (end - start)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums, start, mid-1);
        root.right = helper(nums, mid+1, end);

        return root;
    }
}
