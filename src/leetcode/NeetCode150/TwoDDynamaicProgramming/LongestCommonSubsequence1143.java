package leetcode.NeetCode150.TwoDDynamaicProgramming;

public class LongestCommonSubsequence1143 {

    // Time: O(m * n)
    // Space: O(m * n)
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();

        if (m == 0 || n == 0) return 0;

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i < m + 1; i++) {
            dp[i][n] = 0;
        }

        for (int i = 0; i < n + 1; i++) {
            dp[m][i] = 0;
        }

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (text2.charAt(j) == text1.charAt(i)) {
                    dp[i][j] = 1 + dp[i + 1][j + 1];
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }
        return dp[0][0];
    }
}
