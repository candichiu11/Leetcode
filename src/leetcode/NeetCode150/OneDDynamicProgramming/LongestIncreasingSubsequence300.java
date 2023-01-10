package leetcode.NeetCode150.OneDDynamicProgramming;

public class LongestIncreasingSubsequence300 {

    // Time: O(n^2)
    // Space: O(n)
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) return 0;

        int n = nums.length;
        int[] dp = new int[n];

        // O(n)
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }

        // O(n^2)
        for (int j = 1; j < n; j++) {
            int i = 0;
            while (i < j) {
                if (nums[j] > nums[i]) {
                    if (dp[i] + 1 > dp[j]) {
                        dp[j] = dp[i] + 1;
                    }
                }

                i++;
            }
        }

        int longest = 0;
        // O(n)
        for (int k = 0; k < n; k++) {
            longest = Math.max(longest, dp[k]);
        }

        return longest;
    }
}
