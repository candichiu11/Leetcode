package BackToBackSWE.Graph;

import java.util.LinkedList;
import java.util.Queue;

public class CheckIfAGraphIsBipartite785 {

    //BFS
    //Time: O(N + E), N : number of nodes in the graph, E: number of edges
    //Space: O(N)
    public boolean isBipartite(int[][] graph) {
        if (graph.length == 0) return false;

        Queue<Integer> q = new LinkedList<>();
        int red = 1;
        int green = 2;
        int unvisited = 0;
        int size = graph.length;
        int[] visited = new int[size];

        for (int i = 0; i < size; i++) {
            if (visited[i] != unvisited) continue;

            q.offer(i);
            visited[i] = red;

            while (!q.isEmpty()) {
                int curr = q.poll();
                int[] connectedNodes = graph[curr];
                int currColor = visited[curr];
                int targetNodeColor = currColor == red ? green : red;

                for (int node : connectedNodes) {
                    if (visited[node] == currColor) {
                        return false;
                    }

                    if (visited[node] == unvisited) {
                        q.offer(node);
                        visited[node] = targetNodeColor;
                    }
                }
            }

        }

       return true;

    }
}
