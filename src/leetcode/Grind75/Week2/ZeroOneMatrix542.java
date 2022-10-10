package leetcode.Grind75.Week2;

import java.awt.*;
import java.util.LinkedList;
import java.util.Queue;

public class ZeroOneMatrix542 {

    //Time: O(m * n)
    //Space: O(m * n)
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        Queue<Point> queue = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    queue.add(new Point(i, j));
                } else {
                    mat[i][j] = -1;
                }
            }
        }

        int count = 0;
        while (!queue.isEmpty()) {
                int size = queue.size();
                count++;

                for (int i = 0; i < size; i++) {
                   Point curr = queue.poll();

                   int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
                   for (int[] dir: dirs) {
                       int rowShift = dir[0];
                       int colShift = dir[1];

                       int newRow = curr.x + rowShift;
                       int newCol = curr.y + colShift;

                       if (isInBound(mat, newRow, newCol)) {
                           if (mat[newRow][newCol] == -1) {
                               mat[newRow][newCol] = count;
                               queue.add(new Point(newRow, newCol));
                           }
                       }
                   }
               }
        }
        return mat;

    }

    private boolean isInBound(int[][] mat, int row, int col) {
        return row >= 0 && row < mat.length && col >= 0 && col < mat.length;
    }
}
