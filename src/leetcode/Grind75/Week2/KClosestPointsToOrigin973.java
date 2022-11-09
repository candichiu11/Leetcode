package leetcode.Grind75.Week2;

import java.util.*;

public class KClosestPointsToOrigin973 {

    //Time: O(n* log k)
    //Space: O(k)
    public int[][] kClosest(int[][] points, int k) {
        int n = points.length;
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b) ->
                b[1] * b[1] + b[0] * b[0] - a[1] * a[1] - a[0] * a[0]);

        for (int i = 0; i < n; i++) {
            maxHeap.add(points[i]);

            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

       //return maxHeap.toArray(new int[k][2]);

        int[][] result = new int[k][2];

        while (k > 0) {
            k--;
            result[k] = maxHeap.poll();

        }

        return result;
    }
}
