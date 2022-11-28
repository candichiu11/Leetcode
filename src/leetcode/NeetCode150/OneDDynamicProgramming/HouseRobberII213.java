package leetcode.NeetCode150.OneDDynamicProgramming;

public class HouseRobberII213 {

    // Time: O(N)
    // Space: O(N)
    public int rob(int[] nums) {
        int n = nums.length;
        if (n < 2) return nums[0];

        int[] skipFirst = new int[n - 1];
        int[] skipLast = new int[n - 1];

        for (int i = 0; i < n - 1; i++) {
            skipFirst[i] = nums[i + 1];
            skipLast[i] = nums[i];
        }

        int skipFirstProfit = robI(skipFirst);
        int skipLastProfit = robI(skipLast);

        return Math.max(skipFirstProfit, skipLastProfit);

    }

    private int robI (int[] nums) {
        int n = nums.length;
        if (n < 2) return nums[0];

        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }

        return dp[n - 1];
    }
}
