package BackToBackSWE.RecursionAndBacktracking;

import BackToBackSWE.DynamicProgramming.ArrayProduct238;

import java.util.Arrays;

public class SudokuSolver37 {

    //Time: O(1) constant time since the board size is fixed
    //Space: O(n^2) the board size is fixed, each contains 9 * 9 = 81 elements
    public void solveSudoku(char[][] board) {
        solvedFromCell(board, 0, 0);
        System.out.println(Arrays.deepToString(board));
    }

    private boolean solvedFromCell(char[][] board, int row, int col) {
        //base
        if (col == board[row].length) {
            col = 0;
            row++;
        }

        if (row == board.length) {
            return true;
        }

        if (board[row][col] != '.') {
            return solvedFromCell(board, row, col + 1);
        }

        for (int i = 1; i <= board.length; i++) {
            char c = (char) (i + '0');
            if (canPlaceValue(board, row, col, c)) {
                //choose
                board[row][col] = c;
                //recurse
                if (solvedFromCell(board, row, col + 1)) {
                   return true;
                }
                //unchoose
                board[row][col] = '.';
            }
        }

        return false;
    }

    private boolean canPlaceValue(char[][] board, int row, int col, char c) {
        for (int i = 0; i < board.length; i++) {
            if (board[i][col] == c) {
                return false;
            }
        }

        for (int j = 0; j < board[0].length; j++) {
            if (board[row][j] == c) {
                return false;
            }
        }

        int subgridSize = (int) Math.sqrt(board.length);
        int subRow = row / subgridSize;
        int subCol = col / subgridSize;
        int rowTopLeft = subRow * subgridSize;
        int colTopLeft = subCol * subgridSize;

        for (int i = 0; i < subgridSize; i++) {
            for (int j = 0; j < subgridSize; j++) {
                if (board[rowTopLeft + i][colTopLeft + j] == c) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        SudokuSolver37 test = new SudokuSolver37();
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}};
        test.solveSudoku(board);
    }
}
