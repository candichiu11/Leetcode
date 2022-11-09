package leetcode.NeetCode150.Tries;

import java.util.HashMap;
import java.util.Map;

public class DesignAddAndSearchWordsDataStructure211 {

    class TrieNode {
        public Map<Character, TrieNode> children = new HashMap<>();
        public boolean isWord = false;
    }

    public TrieNode root;
    public DesignAddAndSearchWordsDataStructure211() {
         root = new TrieNode();
    }

    // Time: O(N)
    // Space: O(N), N: word.length()
    public void addWord(String word) {
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

    // Time: O(N) for word without dot '.'
    // O(26 * N) for word contains all '.'
    // Space: O(N)
    public boolean search(String word) {
         return helper(root, word, 0);
    }

    private boolean helper(TrieNode node, String word, int index) {
        //base
        if (node == null) return false;
        if (index == word.length()) {
            return node.isWord;
        }

        char c = word.charAt(index);

        if (!node.children.containsKey(c)) {
            if (c == '.') { //O(26 * N)
                for (TrieNode child : node.children.values()) {
                    if (helper(child, word, index + 1)) {
                        return true;
                    }
                }
            }

            return false;
        } else {
            return helper(node.children.get(c), word, index + 1);
        }
    }
}
