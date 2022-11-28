package leetcode.NeetCode150.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum39 {

    // Time: O(2^T), T: target, if array only contains 1, 1, 1, 1..
    // Space: O(T)
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(candidates, 0, target, new ArrayList<>(), res, 0);
        return res;
    }

    private void dfs(int[] nums, int currSum, int target,
                     List<Integer> partial, List<List<Integer>> res, int index) {
        //base
        if (currSum > target) return;
        if (currSum == target) {
            res.add(new ArrayList<>(partial));
            return;
        }
        if (index >= nums.length) return;

        // don't choose
        dfs(nums, currSum, target,partial, res, index + 1);

        // choose
        partial.add(nums[index]);
        currSum = currSum + nums[index];
        dfs(nums, currSum, target, partial, res, index);
        partial.remove(partial.size() - 1);

    }
}
