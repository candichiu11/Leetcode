package leetcode.Level2.day12DynamicProgramming;

import java.util.Arrays;

public class CoinChange322 {

    //Time: O(coins*amount), Space: O(amount)
    public int coinChange(int[] coins, int amount) {
        int[] fewestNumCoins = new int[amount+1];
        Arrays.fill(fewestNumCoins, amount+1);
        fewestNumCoins[0] = 0;

        for(int coin: coins) {
            for(int i = coin; i <= amount; i++) {
                fewestNumCoins[i] = Math.min(fewestNumCoins[i], fewestNumCoins[i-coin]+1);
            }
        }

        return fewestNumCoins[amount] > amount ? -1 : fewestNumCoins[amount] ;
    }

}
