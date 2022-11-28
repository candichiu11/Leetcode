package leetcode.NeetCode150.Graphs;

public class GraphValidTree261 {

    // Time: O(N)?!
    // Space: O(N)
    int[] parent;
    public boolean validTree(int n, int[][] edges) {
        if (edges.length == n) return false;
        parent = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for (int[] e : edges) {
            if (find(e[0]) == find(e[1])) return false;

            union(e[0], e[1]);
        }

        for (int i = 1; i < n; i++) {
            if (find(i) != find(i - 1)) return false;
        }

        return true;
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
