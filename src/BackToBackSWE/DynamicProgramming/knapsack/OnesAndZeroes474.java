package BackToBackSWE.DynamicProgramming.knapsack;

import java.util.Arrays;

public class OnesAndZeroes474 {

    // Time: O(len * m * n), len = strs.length
    // Space: O(m * n)
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < m + 1; i++) {
            Arrays.fill(dp[i], 0);
        }

        int[] nums;

        for (String str : strs) {
            nums = countZeroAndOne(str);
            for (int i = m; i >= nums[0]; i--) {
                for (int j = n; j >= nums[1]; j--) {
                    if (j >= nums[1] && i >= nums[0]) {
                        dp[i][j] = Math.max(dp[i][j], 1 + dp[i - nums[0]][j - nums[1]]);
                    } else {
                        dp[i][j] = dp[i][j];
                    }
                }
            }
        }

        return dp[m][n];
    }

    private int[] countZeroAndOne(String s) {
        int[] result = new int[2];

        for (char c : s.toCharArray()) {
            if (c == '0') {
                result[0]++;
            } else {
                result[1]++;
            }
        }
        return result;
    }
}
