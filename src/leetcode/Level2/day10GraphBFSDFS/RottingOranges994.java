package leetcode.Level2.day10GraphBFSDFS;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges994 {

    //Time: O(N) , Space: O(N) N: the size of the grid
    public int rottingOrange(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int freshCount = 0;

        //O(N)
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j<grid[0].length; j++) {
                if(grid[i][j] == 2) {
                    queue.add(new int[] {i, j});
                }

                if(grid[i][j] == 1) {
                    freshCount++;
                }
            }
        }

        int[][] directions = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        int time = 0;

        //BFS: O(N)
        while (!queue.isEmpty() && freshCount > 0) {
            int size = queue.size();
            for(int k= size-1; k>=0; k--) {
                int[] rotten = queue.poll();
                for(int[] direction : directions) {
                    int x = rotten[0] + direction[0];
                    int y = rotten[1] + direction[1];
                    if(x < 0 || y < 0 || x >= grid.length || y >= grid[0].length
                            || grid[x][y] == 2 || grid[x][y] == 0) {
                        continue;
                    }
                    queue.add(new int[] {x, y});
                    grid[x][y] = 2;
                    freshCount--;
                }
            }
            time++;
        }
        return freshCount == 0 ? time : -1;
    }

    public static void main(String[] args) {
        RottingOranges994 test = new RottingOranges994();
        int[][] grid = {{2,1,1}, {1,1,0}, {0,1,1}};
       
        System.out.println(Arrays.deepToString(grid));
    }

}
