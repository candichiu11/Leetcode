package leetcode.Level2.day7Tree;

import leetcode.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class PathSumIII437 {

    //Time: O(n), Space: O(n), to keep the hashmap of prefix sum, n: number of nodes.
    Map<Long, Integer> map = new HashMap<>();
    int counter = 0;
    int targetSum;
    long preSum = 0;
    public int pathSumOptimal(TreeNode root, int sum) {
        targetSum = sum;
        //pre-sum=0
        map.put(preSum, 1);
        dfs(root, 0);
        return counter;
    }

    private void dfs(TreeNode root, long currSum) {
        if(root == null) return;
        //Update currSum
        currSum = currSum + root.val;

        //Check if currSum - targetSum exists in the map
        if(map.containsKey(currSum - targetSum)) {
            counter += map.get(currSum - targetSum);
        }

        //Update the map with our currSum
        map.put(currSum, map.getOrDefault(currSum,0) +1);

        //Traverse left side
        dfs(root.left, currSum);

        //Traverse right side
        dfs(root.right, currSum);

        //Remove the currSum off the map
        if(map.get(currSum) == 1) {
            map.remove(currSum);
        } else {
            map.put(currSum, map.get(currSum)-1);
        }
    }

    //Time: O(n^2)
    public int pathSum(TreeNode root, int targetSum) {
        if(root == null) return 0;
        return pathSum(root.left, targetSum) + pathSum(root.right, targetSum) + helper(root, targetSum);
    }

    private int helper(TreeNode root, long targetSum) {
        if(root == null) return 0;
        int counter = 0;

        if(root.val == targetSum) return counter += 1;

        long newSum = targetSum - root.val;
        counter = counter + helper(root.left, newSum);
        counter = counter + helper(root.right, newSum);

        return counter;
    }


}
