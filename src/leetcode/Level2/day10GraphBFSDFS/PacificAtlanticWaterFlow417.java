package leetcode.Level2.day10GraphBFSDFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PacificAtlanticWaterFlow417 {

    //Time: O(M*N) , M: number of rows, N: number of columns
    //Space: O(M*N), space is occupied by dfs calls on the recursion stack
         List<List<Integer>> result = new ArrayList<>();
         int[][] directions = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        if(heights.length == 0 || heights[0].length == 0) return result;

        int row = heights.length;
        int col = heights[0].length;
        boolean[][] pacific = new boolean[row][col];
        boolean[][] atlantic = new boolean[row][col];

        //DFS
        for(int k = 0; k < row; k++) {
            dfs(heights, k, 0, Integer.MIN_VALUE, pacific);
            dfs(heights, k, col - 1, Integer.MIN_VALUE, atlantic);
        }

        for(int l = 0; l < col; l++) {
            dfs(heights, 0, l, Integer.MIN_VALUE, pacific);
            dfs(heights, row-1, l, Integer.MIN_VALUE, atlantic);
        }

        //Prepare the result
        for(int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }
        return result;

    }

    private void dfs(int[][] matrix, int i, int j, int prev, boolean[][] ocean) {
        if(i < 0 || j < 0 || i >= ocean.length || j >= ocean[0].length) return;

        if(matrix[i][j]< prev || ocean[i][j]) {
            return;
        }

        ocean[i][j] = true;

        for(int[] dir : directions) {
            dfs(matrix, i+dir[0], j+dir[1], matrix[i][j], ocean);
        }
    }

    public static void main(String[] args) {
        PacificAtlanticWaterFlow417 test = new PacificAtlanticWaterFlow417();
        int[][] heights = {{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}};
        test.pacificAtlantic(heights);
    }

}
