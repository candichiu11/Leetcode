package leetcode.NeetCode150.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens51Eric {


    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        List<List<String>> res = new ArrayList<>();

        for (char[] c : board) {
            Arrays.fill(c, '.');
        }

        helper(board, 0, 0, n, res);
        return res;

    }

    private void helper(char[][] board, int row, int col, int n, List<List<String>> res) {
        if (col == board[0].length) {
            col = 0;
            row++;
        }

        if (row == n) return;

        if (n == 0) {
            res.add(toString(board));
        }

        if (isValid(board, row, col)) {
            n--;
            board[row][col] = 'Q';
            helper(board, row, col + 1, n, res);

            n++;
            board[row][col] = '.';
        }

        helper(board, row, col + 1, n, res);
    }

    private List<String> toString(char[][] board) {
        List<String> list = new ArrayList<>();

          for(char[] arr : board) {
              StringBuilder sb = new StringBuilder();
              for (char c : arr) {
                  sb.append(c);
              }
              list.add(sb.toString());
          }
          return list;
    }

    private boolean isValid(char[][] board, int row, int col) {
        int m = board.length;

        // top-down / left-right
        for (int i = 0; i < m; i++) {
            if (board[i][col] != '.') {
                return false;
            }

            if (board[row][i] != '.') {
                return false;
            }
        }

        // top-left
        int i = row, j = col;
        while (i >= 0 && j >= 0) {
            if (board[i][j] != '.') {
                return false;
            }
            i--;
            j--;
        }

        // top-right
        i = row;
        j = col;
        while (i >= 0 && j < m) {
            if (board[i][j] != '.') {
                return false;
            }
            i--;
            j++;
        }

        // down-left
        i = row;
        j = col;
        while (i < m && j >= 0) {
            if (board[i][j] != '.') {
                return false;
            }
            i++;
            j--;
        }

        // down-right
        i = row;
        j = col;
        while (i < m && j < m) {
            if (board[i][j] != '.') {
                return false;
            }
            i++;
            j++;
        }

        return true;
    }
}
