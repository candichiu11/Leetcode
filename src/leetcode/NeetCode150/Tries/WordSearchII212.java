package leetcode.NeetCode150.Tries;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordSearchII212 {

    class TrieNode {
        public Map<Character, TrieNode> children = new HashMap<>();
        public boolean isWord = false;
    }

    public TrieNode root = new TrieNode();

    // Time: O(m * n * 4^maxLensOfWord) ?
    // Space: O(N), N: total number of letters in words
    public List<String> findWords(char[][] board, String[] words) {
        int m = board.length;
        int n = board[0].length;
        int len = words.length;
        boolean[][] visited = new boolean[m][n];
        List<String> res = new ArrayList<>();

        for (String word : words) {
            insertTrieNode(word);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(i, j, board, visited, new StringBuilder(), res, root);
            }
        }

        return res;
    }

    private void dfs(int i, int j, char[][] board, boolean[][] visited,
                     StringBuilder sb, List<String> result, TrieNode currTrie) {
        char currChar = board[i][j];
        //base
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) return;
        if (visited[i][j]) return;
        if (!currTrie.children.containsKey(currChar)) return;

        visited[i][j] = true;
        sb.append(currChar);
        currTrie = currTrie.children.get(currChar);

        if (currTrie.isWord) {
            result.add(sb.toString());
            currTrie.isWord = false;
        }

        dfs(i - 1, j, board, visited, sb, result, currTrie);
        dfs(i + 1, j, board, visited, sb, result, currTrie);
        dfs(i, j - 1, board, visited, sb, result, currTrie);
        dfs(i, j + 1, board, visited, sb, result, currTrie);

        visited[i][j] = false;
        sb.deleteCharAt(sb.length() - 1);

    }
    private void insertTrieNode(String word) {
        TrieNode curr = root;
        char[] arr = word.toCharArray();

        for (char c : arr) {
            if (!curr.children.containsKey(c)) {
                curr.children.put(c, new TrieNode());
            }
            curr = curr.children.get(c);
        }

        curr.isWord = true;
    }
}
