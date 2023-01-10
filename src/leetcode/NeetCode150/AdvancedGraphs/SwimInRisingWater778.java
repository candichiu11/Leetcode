package leetcode.NeetCode150.AdvancedGraphs;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class SwimInRisingWater778 {

    // Dijakstra's Algorithm
    // Time: O(E * log V) = O(n^2 * log n)
    // Space: O(E) = O(n^2)
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        boolean[][] visited = new boolean[n][n];
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        minHeap.add(new int[] {grid[0][0], 0, 0});
        visited[0][0] = true;

        while (!minHeap.isEmpty()) {
            int[] curr = minHeap.poll();
            int level = curr[0];
            int row = curr[1];
            int col = curr[2];

            if (row == n - 1 && col == n - 1) return level;

            for (int[] dir : dirs) {
                int rowShift = dir[0];
                int colShift = dir[1];
                int x = row + rowShift;
                int y = col + colShift;

                if (isValid(x, y, grid) && !visited[x][y]) {
                    int maxLevel = Math.max(level, grid[x][y]);
                    minHeap.add(new int[] {maxLevel, x, y});
                    visited[x][y] = true;                }
            }
        }
        return -1;
    }

    private boolean isValid(int row, int col, int[][] grid) {
        return row >= 0 && row < grid.length && col >= 0 && col < grid[0].length;
    }
}
