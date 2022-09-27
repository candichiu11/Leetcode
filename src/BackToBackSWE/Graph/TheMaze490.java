package BackToBackSWE.Graph;

public class TheMaze490 {

    // Time: O(m * n)
    // Space: O(m * n)
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int m = maze.length;
        int n = maze[0].length;

        boolean[][] visited = new boolean[m][n];

        return helper(maze, start, destination, visited);
    }

    private boolean helper(int[][] maze, int[] start, int[] destination, boolean[][] visited) {
        //base
        if (visited[start[0]][start[1]]) return false;

        visited[start[0]][start[1]] = true;

        if (start[0] == destination[0] && start[1] == destination[1]) {
            return true;
        }

        int up = start[0] - 1;
        int right = start[1] + 1;
        int down = start[0] + 1;
        int left = start[1] - 1;

        while (up >= 0 && maze[up][start[1]] == 0) {
            up--;
        }

        if (helper(maze, new int[] {up + 1, start[1]}, destination, visited)) {
            return true;
        }

        while (right < maze[0].length && maze[start[0]][right] == 0) {
            right++;
        }

        if (helper(maze, new int[] {start[0], right - 1}, destination, visited)) {
            return true;
        }

        while (down < maze.length && maze[down][start[1]] == 0) {
            down++;
        }

        if (helper(maze, new int[] {down - 1, start[1]}, destination, visited)) {
            return true;
        }

        while (left >= 0 && maze[start[0]][left] == 0) {
            left--;
        }

        if (helper(maze, new int[] {start[0], left + 1}, destination, visited)) {
            return true;
        }

        return false;
    }

}
