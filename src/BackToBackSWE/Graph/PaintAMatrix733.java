package BackToBackSWE.Graph;

import java.awt.*;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class PaintAMatrix733 {

    //Time: O(m*n), Space: O(m*n) m: number of rows, n: number of columns
    public int[][] paint(int[][] image, int row, int col, int newColor) {
        Queue<Point> queue = new LinkedList<>();
        Set<Point> seen = new HashSet<>();

        Point start = new Point(row, col);
        queue.add(start);
        seen.add(start);

        while(!queue.isEmpty()) {
            Point curr = queue.poll();
            image[curr.x][curr.y] = newColor;

            int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

            for(int[] direction: directions) {
                int rowShift = direction[0];
                int colShift = direction[1];
                int newRow = curr.x + rowShift;
                int newCol = curr.y + colShift;

                if(!isInBound(newRow, newCol, image)) continue;
                Point next = new Point(newRow, newCol);
                if(!seen.contains(next) && image[next.x][next.y] == 0) {
                    queue.add(next);
                    seen.add(next);
                }
            }
        }

        return image;
    }

    private boolean isInBound(int row, int col, int[][] image) {
        return row >= 0 && row < image.length && col >=0 && col < image[row].length;
    }
}
