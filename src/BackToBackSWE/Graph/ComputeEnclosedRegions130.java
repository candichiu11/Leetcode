package BackToBackSWE.Graph;

public class ComputeEnclosedRegions130 {

    // Time: O(m * n)
    // Space: O(m * n)
    public void solve(char[][] board) {
        if (board.length == 0) return;
    /*
      We will:
      1. Do a DFS and preserve cells starting from border 'O's on the left and right borders
      2. Do the same for the top and bottom borders
      3. Capture all 'O's left unpreserved, they by rule must be surrounded
      4. Restore all the preserved 'O's
    */
        preserveCellsLeftRight(board);
        preserveCellsTopDown(board);
        catchAllUnpreservedO(board);
        restoreBoard(board);
    }

    private void preserveCellsLeftRight(char[][] board) {
        for (int row = 0; row < board.length; row++) {
            if (board[row][0] == 'o') {
                preserveCellsDfs(board, row, 0);
            }

            if (board[row][board[0].length - 1] == 'o') {
                preserveCellsDfs(board, row, board[0].length - 1);
            }
        }
    }

    private void preserveCellsTopDown(char[][] board) {
        for (int col = 0; col < board[0].length; col++) {
            if (board[0][col] == 'o') {
                preserveCellsDfs(board, 0, col);
            }

            if (board[board.length - 1][col] == 'o') {
                preserveCellsDfs(board, board.length - 1, col);
            }
        }
    }

    private void catchAllUnpreservedO(char[][] board) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if (board[row][col] == 'o') {
                    board[row][col] = 'x';
                }
            }
        }
    }

    private void restoreBoard(char[][] board) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if (board[row][col] == 'P') {
                    board[row][col] = 'o';
                }
            }
        }
    }

    private void preserveCellsDfs(char[][] board, int row, int col) {
        // base
        if (!isInBound(board, row, col) || board[row][col] != 'o') {
            return;
        }

        // Preserve this character
        board[row][col] = 'P';

        //down
        preserveCellsDfs(board, row + 1, col);
        //up
        preserveCellsDfs(board, row - 1, col);
        //right
        preserveCellsDfs(board, row, col + 1);
        //left
        preserveCellsDfs(board, row, col - 1);

    }

    private boolean isInBound(char[][] board, int row, int col) {
        return row >= 0 && row < board.length && col >=0 && col < board[0].length;
    }

}
