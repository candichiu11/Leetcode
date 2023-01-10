package leetcode.NeetCode150.TwoDDynamaicProgramming;

public class BestTimeToBuyAndSellStockWithCooldown {

    // Time: O(N)
    // Space: O(1)
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 0) return 0;

        int sold = 0;
        int held = -prices[0];
        int reset = 0;

        for (int i = 1; i < n; i++) {
            int prevSold = sold;

            sold = Math.max(sold, held + prices[i]);
            held = Math.max(held, reset - prices[i]);
            reset = Math.max(reset, prevSold);
        }

        return Math.max(sold, reset);
    }
}
