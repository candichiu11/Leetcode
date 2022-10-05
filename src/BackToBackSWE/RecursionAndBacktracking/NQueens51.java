package BackToBackSWE.RecursionAndBacktracking;

import java.util.ArrayList;
import java.util.List;

public class NQueens51 {

    //Time: O(N!)
    /*
    We have N choice in the first row, (N - 1) in the second row, (N - 2) in the next and so on.
     */
    //Space: O(N * N) required for board
    // https://github.com/bephrem1/backtobackswe/blob/master/Dynamic%20Programming%2C%20Recursion%2C%20%26%20Backtracking/NQueens/NQueens.java
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> board = new ArrayList<>();
        solve(0, n, new ArrayList<>(), board);
        System.out.println(board);
        return board;
    }

    private void solve(int row, int n, List<Integer> colPlacement, List<List<String>> board) {
        //base
        if (row == n) {
            board.add(generateBoard(colPlacement, n));
            return;
        }

        for (int col = 0; col < n; col++) {
            colPlacement.add(col);
            if (isValid(colPlacement)) {
                solve(row + 1, n, colPlacement, board);
            }
            colPlacement.remove(colPlacement.size() - 1);
        }

    }

    private boolean isValid(List<Integer> colPlacement) {
        int newRow = colPlacement.size() - 1;

        for (int i = 0; i < newRow; i++) {
            int rowDistance = Math.abs(newRow - i);
            int colDistance = Math.abs(colPlacement.get(newRow) - colPlacement.get(i));

            if (colDistance == 0 || rowDistance == colDistance) {
                return false;
            }
        }
        return true;
    }

    private List<String> generateBoard(List<Integer> colPlacement, int n) {
        List<String> board = new ArrayList<>();
        int totalItemPlaced = colPlacement.size();

        for (int row = 0; row < totalItemPlaced; row++) {
            StringBuilder sb = new StringBuilder();

            for (int col = 0; col < n; col++) {
                if (col == colPlacement.get(row)) {
                    sb.append("Q");
                } else {
                    sb.append(".");
                }
            }
            board.add(sb.toString());
        }

        return board;
    }

    public static void main(String[] args) {
        NQueens51 test = new NQueens51();
        test.solveNQueens(4);
    }
}
