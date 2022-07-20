package leetcode.Level2.day1;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix54 {

    public static void main ( String [ ] args ) {
          SpiralMatrix54 sp = new SpiralMatrix54();
        int[][] matrix = {{1,2,3},
                          {4,5,6},
                          {7,8,9}};
          sp.spiralOrder(matrix);
    }

    //Time: O(m*n) , m: rows, n: column, //Space: O(1), we don't use other data structures,
    //Remember that we don't include the output array in the space complexity
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();

        if(matrix.length == 0) {
            return result;
        }

        int startRow = 0;
        int startColumn = 0;
        int endRow = matrix.length-1;
        int endColumn = matrix[0].length-1;

        while(startRow<=endRow && startColumn<=endColumn) {

            //move to right
            for(int j=startColumn; j<=endColumn; j++) {
                result.add(matrix[startRow][j]);
            }
            startRow++;

            //move down
            for(int i=startRow; i<=endRow; i++) {
                result.add(matrix[i][endColumn]);
            }
            endColumn--;

            //move to left
            if(startRow<=endRow) {
                for(int j=endColumn; j>=startColumn; j--) {
                    result.add(matrix[endRow][j]);
                }
            }
            endRow--;

            //move to top
            if(startColumn<=endColumn) {
                for(int i=endRow; i>=startRow; i--) {
                    result.add(matrix[i][startColumn]);
                }
            }
            startColumn++;

        }
      return result;
    }
}
