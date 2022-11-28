package leetcode.NeetCode150.AdvancedGraphs;

import java.util.*;

public class NetworkDelayTime743 {

    // Dijkstra's algorithm  O(E log V), E: number of edges, times.length, V: number of vortex, n
    // Time: O(E * log V)
    // Space: O(E), E = V^2
    public int networkDelayTime(int[][] times, int n, int k) {

        // Build a graph // Space: O(E)
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] t : times) {
            int source = t[0];
            int target = t[1];
            int time = t[2];

            if (!graph.containsKey(source)) {
                graph.put(source, new ArrayList<>());
            }

            graph.get(source).add(new int[] {target, time});

        }

        // Create a minHeap // Space: O(E)
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        minHeap.add(new int[] {k, 0});

        // Create a visited Set
        Set<Integer> visited = new HashSet<>();
        int res = 0;

        while (!minHeap.isEmpty()) {
            int[] arr = minHeap.poll();
            int currSource = arr[0];
            int currTime = arr[1];

            if (visited.contains(currSource)) continue;

            visited.add(currSource);
            res = currTime;

            if (!graph.containsKey(currSource)) continue;

            for (int[] edge : graph.get(currSource)) {
                int targetNode = edge[0];
                int targetTime = edge[1];

                minHeap.add(new int[] {targetNode, currTime + targetTime});
            }

        }
        return visited.size() == n ? res : -1;

    }
}
