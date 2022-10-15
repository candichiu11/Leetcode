package leetcode.Level2.day12DynamicProgramming;

import java.util.Arrays;

public class CoinChange322 {

    // Top Down
    // Time: A * O(N), A: amount, N: coins.length
    // Space: O(A), call stack depth is A at maximum
    public int coinChangeTopDown(int[] coins, int amount) {
        if (amount < 1) return 0;
        Integer[] cache = new Integer[amount + 1];

        return dfs(coins, amount, cache);
    }

    private int dfs(int[] coins, int remainder, Integer[] cache) {
        //base
        if (remainder < 0) {
            return -1;
        }

        if (remainder == 0) {
            return 0;
        }

        if (cache[remainder] != null) {
            return cache[remainder];
        }

        int minCoins = Integer.MAX_VALUE;
        for (int coin : coins) {
            int changeResult = dfs(coins, remainder - coin, cache);

            if (changeResult >=0 && changeResult < minCoins) {
                minCoins = 1 + changeResult;
            }
        }
        cache[remainder] = minCoins;

        return minCoins == Integer.MAX_VALUE ? -1 : cache[remainder];
    }

    // Button Up
    // Time: A * O(N), A: amount, N: coins.length
    // Space: O(A), dp array
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
       int[] dp = new int[amount + 1];
       Arrays.fill(dp, amount + 1);
       dp[0] = 0;

       for (int coin : coins) {
           for (int i = 1; i < amount + 1; i++) {
               if (coin <= i) {
                   dp[i] = Math.min(1 + dp[i - coin], dp[i]);
               }

           }
       }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }

}
