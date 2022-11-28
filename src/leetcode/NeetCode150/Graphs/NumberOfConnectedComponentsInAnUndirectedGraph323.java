package leetcode.NeetCode150.Graphs;

public class NumberOfConnectedComponentsInAnUndirectedGraph323 {

    // Time: O(N)
    // Space: O(N)
    int[] parent;
    public int countComponents(int n, int[][] edges) {
        int m = edges.length;
        parent = new int[n];
        int count = n;

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for (int[] edge : edges) {
            int iroot = find(edge[0]);
            int jroot = find(edge[1]);

            if (iroot != jroot) {
                parent[jroot] = iroot;
                count--;
            }

        }
        return count;

    }

    private int find(int i) {
        while (parent[i] != i) {
            i = parent[i];
        }

        return i;
    }
}
