package BackToBackSWE.DynamicProgramming;

import java.util.Arrays;

public class DecodeWays91 {

    //Time: O(n) n: length of string s
    //Space: O(n) dp array
    public int numDecodings(String s) {
        int[] dp = new int[s.length()];
        Arrays.fill(dp, -1);

        return helper(s, 0, dp);
    }

    private int helper(String s, int progressIndex, int[] dp) {
        int sLen = s.length();
        //base
        if (progressIndex >= sLen) {
            return 1;
        }

        //cached answers
        if (dp[progressIndex] > -1) {
            return dp[progressIndex];
        }

        int totalWays = 0;

        for (int i = 1; i <= 2; i++) {
            if (progressIndex + i <= sLen) {
                String snippet = s.substring(progressIndex, progressIndex + i);

                if (isValid(snippet)) {
                    totalWays = totalWays + helper(s, progressIndex + i, dp);
                }
            }
        }

        dp[progressIndex] = totalWays;

        return dp[progressIndex];
    }

    private boolean isValid(String s) {
        if (s.length() == 0) return false;
        if (s.charAt(0) == '0') return false;

        int sInt = Integer.parseInt(s);

        return sInt >= 1 && sInt <= 26;
    }

    public static void main(String[] args) {
        DecodeWays91 test = new DecodeWays91();
        System.out.println(test.numDecodings("223"));
    }
}
