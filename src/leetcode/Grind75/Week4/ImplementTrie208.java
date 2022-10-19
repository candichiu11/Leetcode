package leetcode.Grind75.Week4;

import java.util.HashMap;
import java.util.Map;

// Time: O(N) N: the length of word
// Space: O(N), In the worst case newly inserted key doesn't share with a prefix already inserted.
public class ImplementTrie208 {
    class TrieNode {
        public Map<Character, TrieNode> children = new HashMap<>();
        public boolean isWord = false;
    }

    public TrieNode root;

    public ImplementTrie208() {
        root = new TrieNode();
    }

    public void insert(String word) {
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

    public boolean search(String word) {
        TrieNode curr = root;
        char[] arr = word.toCharArray();

        for (char c : arr) {
            if (!curr.children.containsKey(c)) {
                return false;
            }

            curr = curr.children.get(c);
        }
        return curr.isWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        char[] arr = prefix.toCharArray();

        for (char c : arr) {
            if (!curr.children.containsKey(c)) {
                return false;
            }

            curr = curr.children.get(c);
        }
        return true;
    }
}
