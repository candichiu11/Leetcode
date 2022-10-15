package BackToBackSWE.DynamicProgramming;

public class CombinationSumIV377 {

    // Time: target * O(N)
    // Space: O(target)
    Integer[] cache;
    public int combinationSum4(int[] nums, int target) {
        cache = new Integer[target + 1];
        return dfs(nums, target);
    }

    private int dfs(int[] nums, int currSum) {
        //base
        if (currSum < 0) return 0;
        if (currSum == 0) return 1;
        if (cache[currSum] != null) return cache[currSum];

        int totalWays = 0;
        for (int num : nums) {
            totalWays += dfs(nums, currSum - num);
        }
        cache[currSum] = totalWays;

        return totalWays;
    }
}
