package leetcode.NeetCode150.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII40 {

    // Time: O(2^N), branch factor: 2, each number is either included or excluded in a combination.
    // Space: O(N)
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(candidates);
        helper(candidates, 0, target, res, new ArrayList<>());

        return res;
    }

    private void helper(int[] nums, int idx, int target, List<List<Integer>> res, List<Integer> partial) {
        int n = nums.length;
        //base

        if (target == 0) {
            res.add(new ArrayList<>(partial));
            return;
        }
        if (target < 0) return;

        for (int i = idx; i < n; i++) {
            if (i > idx && nums[i] == nums[i - 1]) {
                continue;

            }

            partial.add(nums[i]);
            helper(nums, i + 1, target - nums[i], res, partial);
            partial.remove(partial.size() - 1);

        }

    }
}
