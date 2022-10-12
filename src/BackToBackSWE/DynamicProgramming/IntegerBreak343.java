package BackToBackSWE.DynamicProgramming;

public class IntegerBreak343 {

    //Memoization / DFS
    // Time: O(n)
    // Space: O(n)
    Integer[] cache;
    public int integerBreak(int n) {
        cache = new Integer[n + 1];
        return dfs(n);
    }

    private int dfs(int n) {
        //base
        if (n < 2) {
            return 0;
        }

        if (cache[n] != null) {
           return cache[n];
        }
        int maxProduct = 0;
        for (int i = 1; i < n; i++) {
            int currMax = Math.max(n - i, dfs(n - i));
            maxProduct = Math.max(maxProduct, i * currMax);

        }
        cache[n] = maxProduct;

        return maxProduct;

    }
}
