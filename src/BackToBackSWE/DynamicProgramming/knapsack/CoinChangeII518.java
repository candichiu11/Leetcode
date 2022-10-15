package BackToBackSWE.DynamicProgramming.knapsack;

public class CoinChangeII518 {

    // Time: O(A * C) A: amount, C: total number of coins
    // Space: O(A * C)
    public int change(int amount, int[] coins) {
        if (amount == 0) return 1;

        int n = coins.length;
        int[][] dp = new int[n + 1][amount + 1];

        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = 1;
        }

        for (int j = 1; j < amount + 1; j++) {
            dp[0][j] = 0;
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < amount + 1; j++) {
                if (coins[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
                }
            }
        }

        return dp[n][amount];
    }
}

// // 1D solution
// happygirlzt(youtube)

// Time: O(A * C) A: amount, C: total number of coins
// Space: O(A)
// class Solution {
//     public int change(int amount, int[] coins) {
//         int n = coins.length;
//         int[] dp = new int[amount + 1];

//         dp[0] = 1;
//         for (int coin : coins) {
//             for (int j = coin; j < amount + 1; j++) {
//                 dp[j] += dp[j - coin];
//             }
//         }

//          return dp[amount];
//     }


// }