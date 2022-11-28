package leetcode.NeetCode150.Backtracking;

public class WordSearch79 {

    // Time: O(m * n)
    // Space: O(m * n)
    public boolean exist(char[][] board, String word) {
          for (int i = 0; i < board.length; i++) {
              for (int j = 0; j < board[i].length; j++) {
                  if (board[i][j] == word.charAt(0) && dfs(board, i, j, 0, word)){
                      return true;
                  }
              }
          }

          return false;
    }

    private boolean dfs(char[][] board, int i, int j, int index, String word) {
        //base
        if (index == word.length()) {
            return true;
        }

        if (i < 0 || j < 0 || i >= board.length || j >= board[i].length || board[i][j] != word.charAt(index)) {
            return false;
        }

        char temp = board[i][j];
        board[i][j] = ' ';
        Boolean found =  dfs(board, i - 1, j, index + 1, word) ||
                         dfs(board, i + 1, j, index + 1, word) ||
                         dfs(board, i, j - 1, index + 1, word) ||
                         dfs(board, i, j + 1, index + 1, word);
        board[i][j] = temp;
        return found;
    }
}
