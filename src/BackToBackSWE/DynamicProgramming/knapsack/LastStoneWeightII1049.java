package BackToBackSWE.DynamicProgramming.knapsack;

public class LastStoneWeightII1049 {

    //Time: O(n * m) n = stones.length, m = Sum
    //Space: O(n * m)
    public int lastStoneWeightII(int[] stones) {
        int n = stones.length;
        int sum = 0;

        for (int stone : stones) {
            sum += stone;
        }

        boolean[][] dp = new boolean[n + 1][sum + 1];

        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = true;
        }

        for (int j = 1; j < sum + 1; j++) {
            dp[0][j] = false;
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                if (stones[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                }

                if (stones[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - stones[i-1]];
                }
            }
        }

        int diff = Integer.MAX_VALUE;
        for (int j = sum/2; j >= 0; j--) {
            if (dp[n][j]) {
               diff = sum - 2*j;
                break;
            }
        }

        return diff;

    }
}
