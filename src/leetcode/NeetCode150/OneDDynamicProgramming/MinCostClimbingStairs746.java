package leetcode.NeetCode150.OneDDynamicProgramming;

public class MinCostClimbingStairs746 {

    // Time: O(N)
    // Space: O(N)
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] minCost = new int[n + 1];
        minCost[0] = 0;
        minCost[1] = 0;

        for (int i = 2; i < n + 1; i++) {
            int minCostOneStep = minCost[i - 1] + cost[i - 1];
            int minCostTwoStep = minCost[i - 2] + cost[i - 2];
            minCost[i] = Math.min(minCostOneStep, minCostTwoStep);
        }

        return minCost[n];
    }
}
