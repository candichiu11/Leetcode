package leetcode.NeetCode150.TwoDDynamaicProgramming;

public class InterleavingString97 {

    // Top Down
    // Time: O(n1 * n2)
    // Space: O(n1 * n2)
    public boolean isInterleave(String s1, String s2, String s3) {
        int n1 = s1.length();
        int n2 = s2.length();
        int n3 = s3.length();

        if (n1 + n2 != n3) return false;

        int[][] cache = new int[n1 + 1][n2 + 1];

        for (int i = 0; i < n1 + 1; i++) {
            for (int j = 0; j < n2 + 1; j++) {
                cache[i][j] = -1;
            }
        }
        return dfs(0, 0, s1, s2, s3, cache);

    }

    private boolean dfs(int p1, int p2, String s1, String s2, String s3, int[][] cache) {
        char[] s1Arr = s1.toCharArray();
        char[] s2Arr = s2.toCharArray();
        char[] s3Arr = s3.toCharArray();
        //base
        if (p1 == s1.length() && p2 == s2.length()) {
            return true;
        }

        if (cache[p1][p2] > -1) {
            return cache[p1][p2] == 1;
        }

        int p3 = p1 + p2;
        char s1Char = p1 == s1.length() ? '0' : s1Arr[p1];
        char s2Char = p2 == s2.length() ? '0' : s2Arr[p2];
        char s3Char = s3Arr[p3];

        if (s1Char == s3Char && s2Char == s3Char) {
            if (dfs(p1 + 1, p2, s1, s2, s3, cache) || dfs(p1, p2 + 1, s1, s2, s3, cache)) {
                cache[p1][p2] = 1;
            } else {
                cache[p1][p2] = 0;
            }
        } else if (s1Char == s3Char) {
            if (dfs(p1 + 1, p2, s1, s2, s3, cache)) {
                cache[p1][p2] = 1;
            } else {
                cache[p1][p2] = 0;
            }
        } else if (s2Char == s3Char) {
            if (dfs(p1, p2 + 1, s1, s2, s3, cache)) {
                cache[p1][p2] = 1;
            } else {
                cache[p1][p2] = 0;
            }
        } else {
            cache[p1][p2] = 0;
        }

        return cache[p1][p2] == 1;
    }

    // Buttom up
    // Time: O(n1 * n2)
    // Space: O(n1 * n2)
    public boolean isInterleaveButtomUp(String s1, String s2, String s3) {
        int n1 = s1.length();
        int n2 = s2.length();
        int n3 = s3.length();

        if (n1 + n2 != n3) return false;

        boolean[][] dp = new boolean[n1 + 1][n2 + 1];

        dp[n1][n2] = true;

        char[] s1Arr = s1.toCharArray();
        char[] s2Arr = s2.toCharArray();
        char[] s3Arr = s3.toCharArray();


        for (int i = n1; i >= 0; i--) {
            for (int j = n2; j >= 0; j--) {
                char s1Char = i == n1 ? '0' : s1Arr[i];
                char s2Char = j == n2 ? '0' : s2Arr[j];
                char s3Char = i + j == n3 ? '0' : s3Arr[i + j];

                if (dp[i][j]) continue;

                if (s1Char == s3Char && s2Char == s3Char) {
                    dp[i][j] = dp[i + 1][j] || dp[i][j + 1];

                } else if (s1Char == s3Char) {
                    dp[i][j] = dp[i + 1][j];

                } else if (s2Char == s3Char) {
                    dp[i][j] = dp[i][j + 1];

                } else {
                    dp[i][j] = false;
                }
            }
        }
        return dp[0][0];
    }
}
