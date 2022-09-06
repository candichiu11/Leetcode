package BackToBackSWE.RecursionAndBacktracking;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

//Time: O(m * n)
//Space: O(m * n)
public class NumberOfDistinctIslands694 {

    int baseRow;
    int baseCol;
    final int water = 0, land = 1;
    int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    int[][] grid;

    public int numDistinctIslands(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        Set<String> distinctIslands = new HashSet<>();
        this.grid = grid;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == water) continue;
                baseRow = i;
                baseCol = j;
                StringBuilder pattern = new StringBuilder();
                bfs(i, j, pattern);
                distinctIslands.add(pattern.toString());
            }
        }

        return distinctIslands.size();
    }

    private void bfs(int row, int col, StringBuilder sb) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{row, col});
        grid[row][col] = water;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            sb.append(curr[0] - baseRow);
            sb.append(",");
            sb.append(curr[1] - baseCol);
            sb.append("|");

            for (int[] direction : directions) {
                int rowShift = direction[0];
                int colShift = direction[1];
                int newRow = curr[0] + rowShift;
                int newCol = curr[1] + colShift;

                if (isInBounds(newRow, newCol, grid) && grid[newRow][newCol] == land) {
                    queue.add(new int[]{newRow, newCol});
                    grid[newRow][newCol] = water;
                }

            }
        }
    }

    private boolean isInBounds(int row, int col, int[][] grid) {
        return row >= 0 && row < grid.length && col >= 0 && col < grid[0].length;
    }

    public static void main(String[] args) {
        NumberOfDistinctIslands694 test = new NumberOfDistinctIslands694();
        int[][] grid = {{1, 1, 0, 0, 0}, {1, 1, 0, 0, 0}, {0, 0, 0, 1, 1}, {0, 0, 0, 1, 1}};
        System.out.println(test.numDistinctIslands(grid));
    }
}
