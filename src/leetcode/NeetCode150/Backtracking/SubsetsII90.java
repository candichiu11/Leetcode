package leetcode.NeetCode150.Backtracking;

import java.util.*;

public class SubsetsII90 {

    // Time: O(n*log n + 2^n), n: nums.length
    // Space: O(n)
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        Arrays.sort(nums); // O(n * log n)
        helper(nums, 0, new ArrayList<>(), set);

        for (List<Integer> list : set) {
            res.add(list);
        }

        return res;
    }

    private void helper(int[] nums, int idx, List<Integer> partial, Set<List<Integer>> resultSet) {
        int n = nums.length;
        //base
        if (idx > n) {
            return;
        }

        if (idx == n) {
            resultSet.add(new ArrayList<>(partial));
            return;
        }

        helper(nums, idx + 1, partial, resultSet);

        partial.add(nums[idx]);
        helper(nums, idx + 1, partial, resultSet);
        partial.remove(partial.size() - 1);
    }
}
