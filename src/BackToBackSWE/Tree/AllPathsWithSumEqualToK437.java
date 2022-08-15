package BackToBackSWE.Tree;

import leetcode.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class AllPathsWithSumEqualToK437 {

    //Time: O(n), Space: O(n), n: number of nodes in the tree
    int count = 0;
    public int pathSum(TreeNode root, int sum) {
       if(root == null) return 0;
       Map<Long, Integer> map = new HashMap<>();
       map.put((long) 0, 1);

       return helper(root, (long) 0, sum, map);
    }

    private int helper(TreeNode node, long currSum, int targetSum, Map<Long, Integer> map) {
        if (node == null) return 0;

        currSum += node.val;

        if (map.containsKey(currSum - targetSum)) {
            count += map.get(currSum - targetSum);
        }

        if(map.containsKey(currSum)) {
            map.put(currSum, map.get(currSum) + 1);
        } else {
            map.put(currSum, 1);
        }

        helper(node.left, currSum, targetSum, map);
        helper(node.right, currSum, targetSum, map);

        if(map.get(currSum) == 1) {
            map.remove(currSum);
        } else {
            map.put(currSum, map.get(currSum) - 1);
        }
        return count;
    }
}
