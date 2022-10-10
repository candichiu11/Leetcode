package BackToBackSWE.DynamicProgramming.knapsack;

public class TargetSum494 {

    //Time: O(n * m) n = nums.length + 1, m = newTarget + 1
    //Space: O(n * m)
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int sum = 0;

        for (int num : nums) {
            sum += num;
        }

        int newTarget = (sum + target)/2;

        if (sum < target || (sum + target) % 2 != 0 || newTarget < 0) {
            return 0;
        }

        int[][] dp = new int[n + 1][newTarget + 1];

        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = 1;
        }

        for (int j = 1; j < newTarget + 1; j++) {
            dp[0][j] = 0;
        }

        /*
        we started with 0 because suppose we have 0 in the array then
        one way to make target 0 is not take any element and other way is take this 0.. so here we have 2 ways.
        (for eg in dp table we add dp[i-1][j-nums[]i-1] & dp[i-1][j]... in case of 0 they point to same cell in table)
        .... Similary for more 0's in the array we find many ways to make target 0 by selecting some 0's from the array
        and rejecting some
         */

        for (int i = 1; i < n + 1; i++) {
            for (int j = 0; j < newTarget + 1; j++) {
                if (nums[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                }

                if (nums[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i - 1]];
                }
            }
        }

        return dp[n][newTarget];
    }
}
