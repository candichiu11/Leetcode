package leetcode.NeetCode150.Graphs;

public class RedundantConnection684 {

    // Time: O(N)
    // Space: O(N)
    int[] parent;
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        parent = new int[n + 1];

        for (int i = 1; i < n + 1; i++) {
            parent[i] = i;
        }

        for (int[] edge : edges) {
            if (find(edge[0]) == find(edge[1])) return edge;
            union(edge[0], edge[1]);
        }
        return null;

    }

    private int find(int i) {
        while (parent[i] != i) {
            i = parent[i];
        }

        return i;
    }

    private void union(int i, int j) {
        int iroot = find(i);
        int jroot = find(j);

        if (iroot != jroot) {
            parent[jroot] = iroot;
        }
    }
}
