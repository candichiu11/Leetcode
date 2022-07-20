package leetcode.Level2.day1;

import java.util.Arrays;

public class WhereWillTheBallFall1706 {

    public static void main ( String [ ] args ) {
        WhereWillTheBallFall1706 w = new WhereWillTheBallFall1706();
        int[][] grid = {
                {1,1,1,1,1,1},
                {-1,-1,-1,-1,-1,-1},
                {1,1,1,1,1,1},
                {-1,-1,-1,-1,-1,-1}
        };
        w.findBall(grid);
    }

    //Time: O(mn)
    public int[] findBall(int[][] grid) {
        int rowLength = grid.length;
        int colLength = grid[0].length;
        int[] answer = new int[colLength];
        Arrays.fill(answer, -1);

        for(int i=0; i<colLength; i++) {
            int x = 0;
            int y = i;

            while (true) {
                if(x>=rowLength) {
                    if(y>=0 && y<colLength) {
                        answer[i] = y;
                    }
                    break;

                } else {
                   if(y+1<colLength && grid[x][y]==1 && grid[x][y+1]==1) {
                       x++;
                       y++;
                   } else if (y-1>=0 && grid[x][y]==-1 && grid[x][y-1]==-1) {
                       x++;
                       y--;
                   } else {
                       break;
                   }

                }
            }

        }
       // System.out.println(Arrays.toString(answer));
        return answer;

    }
}
