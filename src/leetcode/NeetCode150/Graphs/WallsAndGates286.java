package leetcode.NeetCode150.Graphs;

import java.util.LinkedList;
import java.util.Queue;

public class WallsAndGates286 {

//    // DFS
//    // Time: O(k * m * n) k: number of zeros
//    public void wallsAndGates(int[][] rooms) {
//        int m = rooms.length;
//        int n = rooms[0].length;
//
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                if (rooms[i][j] == 0) {
//                    dfs(rooms, i, j, 0);
//                }
//
//            }
//        }
//
//    }
//
//    private void dfs(int[][] rooms, int i, int j, int d) {
//        if (!isInBound(rooms, i, j)) return;
//        if (rooms[i][j] == -1) return;
//        if (rooms[i][j] < d) return;
//
//        rooms[i][j] = d;
//        dfs(rooms, i - 1, j, d + 1);
//        dfs(rooms, i + 1, j, d + 1);
//        dfs(rooms, i, j - 1, d + 1);
//        dfs(rooms, i, j + 1, d + 1);
//
//    }
//
//    private boolean isInBound(int[][] rooms, int i, int j) {
//        return i >= 0 && i < rooms.length && j >= 0 && j < rooms[0].length;
//    }
    // BFS
    // Time : O(m * n)
    // Space: O(m * n)
    public void wallsAndGates(int[][] rooms) {
        int m = rooms.length;
        int n = rooms[0].length;
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rooms[i][j] == 0) {
                    queue.add(new int[] {i, j});
                }
            }
        }

        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int k = 0; k < size; k++) {
                int[] gate = queue.poll();

                for (int[] dir : dirs) {
                    int x = dir[0] + gate[0];
                    int y = dir[1] + gate[1];

                    if (!isInBound(rooms, x, y) || rooms[x][y] == -1 || (rooms[x][y] >= 0 && rooms[x][y] < 2147483647)) {
                        continue;
                    }

                    rooms[x][y] = rooms[gate[0]][gate[1]] + 1;
                    queue.add(new int[] {x, y});
                }

            }

        }

    }

    private boolean isInBound(int[][] rooms, int i, int j) {
        return i >= 0 && i < rooms.length && j >= 0 && j < rooms[0].length;
    }
}
