package leetcode.NeetCode150.Graphs;

public class NumberOfIslands200 {

    // Time: O(m * n)
    // Space: O(m * n)
    public int numIslands(char[][] grid) {
        if (grid.length == 0) return 0;
        int m = grid.length;
        int n = grid[0].length;
        int numOfIsland = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    numOfIsland++;
                }
            }
        }

        return numOfIsland;
    }

    private void dfs(char[][] grid, int i, int j) {
        //base
        if (!isInBound(grid, i, j) || grid[i][j] != '1') {
            return;
        }

        grid[i][j] = '2';
        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);
    }

    private boolean isInBound(char[][] grid, int i, int j) {
        return i >= 0 && i < grid.length && j >= 0 && j < grid[0].length;
    }
}
