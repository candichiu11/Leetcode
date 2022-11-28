package leetcode.NeetCode150.AdvancedGraphs;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class MinCostToConnectAllPoints1584 {

    // Time: O(n^2 log n)
    // Space: O(n^2), the size of the minHeap, worst case
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        Set<Integer> visited = new HashSet<>();
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        minHeap.add(new int[]{0, 0});

        int distance = 0;

        while (visited.size() < n) {
            int[] arr = minHeap.poll();
            int currDistance = arr[0];
            int currNode = arr[1];

            if (visited.contains(currNode)) continue;

            visited.add(currNode);
            distance += currDistance;

            for (int nextNode = 0; nextNode < n; nextNode++) {
                if (!visited.contains(nextNode)) {
                    int nextDistance = Math.abs(points[nextNode][0] - points[currNode][0]) +
                            Math.abs(points[nextNode][1] - points[currNode][1]);

                    minHeap.add(new int[] {nextDistance, nextNode});
                }

            }

        }

        return distance;
    }
}
