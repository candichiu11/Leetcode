package leetcode.NeetCode150.ArraysAndHashing;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku36 {

    // Time: O(N^2), N: board.length
    // Space: O(N^2)
    /*
    For each row, there can be a maximum of N integers.
    Thus for N rows, the space complexity is N^2.
    Similarly, the space complexity for columns and boxes is N^2 too.
    Therefore total space complexity = O(3N^2) = O(N^2)
     */
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            Set<Character> rowSet = new HashSet<>();
            Set<Character> colSet = new HashSet<>();

            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != '.' && !rowSet.add(board[i][j])) {
                    return false;
                }

                if (board[j][i] != '.' && !colSet.add(board[j][i])) {
                    return false;
                }
            }
        }


      for (int i = 0; i < 9; i = i + 3){
        for (int j = 0; j < 9; j = j + 3) {

            if (!checkSubgrid(board, i, j)) {
                return false;
            }
        }

    }
       return true;

}

    private boolean checkSubgrid(char[][] board, int row, int col) {
        Set<Character> subgridSet = new HashSet<>();
        int subgridSize = (int) Math.sqrt(board.length);
        int subRow = row / subgridSize;
        int subCol = col / subgridSize;

        int subTopLeftRow = subRow * subgridSize;
        int subTopLeftCol = subCol * subgridSize;


        for (int k = 0; k < subgridSize; k++) {
            for (int l = 0; l < subgridSize; l++) {
                if (board[subTopLeftRow + k][subTopLeftCol + l] != '.') {
                    if (!subgridSet.add(board[subTopLeftRow + k][subTopLeftCol + l])) {
                        return false;
                    }
                }

            }
        }
        return true;
    }

}
