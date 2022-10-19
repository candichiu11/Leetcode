package BackToBackSWE.DynamicProgramming;

public class MinimumCostForTickets983 {

    // Time: O(W), W: 365
    // Space: O(W)
    public int mincostTickets(int[] days, int[] costs) {
        int[] dp = new int[days.length];
        return dfs(days, costs, 0, dp);
    }

    private int dfs(int[] days, int[] costs, int index, int[] dp) {
        //base
        if (index >= days.length) {
            return 0;
        }

        if (dp[index] > 0) {
            return dp[index];
        }

        // 1 day pass
        int opt1 = costs[0] + dfs(days, costs, index + 1, dp);

        // 7 days pass
        int k = index;
        for (int i = index; i < days.length; i++) {
            if (days[i] <= days[index] + 6) {
                k++;
            }
        }
        int opt2 = costs[1] + dfs(days, costs, k, dp);

        // 30 days pass
        k = index;
        for (int i = index; i < days.length; i++) {
            if (days[i] <= days[index] + 29) {
                k++;
            }
        }
        int opt3 = costs[2] + dfs(days, costs, k, dp);

        int min = Math.min(opt1, Math.min(opt2, opt3));
        dp[index] = min;

        return dp[index];
    }
}
