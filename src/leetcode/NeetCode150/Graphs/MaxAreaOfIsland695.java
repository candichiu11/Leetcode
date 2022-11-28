package leetcode.NeetCode150.Graphs;

public class MaxAreaOfIsland695 {

    // Time: O(m * n)
    // Space: O(1)
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int maxArea = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    maxArea = Math.max(maxArea, dfs(grid, i, j));

                }

            }
        }

        return maxArea;
    }

    private int dfs(int[][] grid, int i, int j) {
        //base
        if (!isInBound(grid, i, j) || grid[i][j] != 1) {
            return 0;
        }

        int area = 1;
        grid[i][j] = 2;
        area += dfs(grid, i - 1, j) +
                dfs(grid, i + 1, j) +
                dfs(grid, i, j - 1) +
                dfs(grid, i, j + 1);

        return area;
    }

    private boolean isInBound(int[][] grid, int i, int j) {
        return i >= 0 && i < grid.length && j >= 0 && j < grid[0].length;
    }
}
