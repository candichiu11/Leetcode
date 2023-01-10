package BackToBackSWE.Graph;

import java.util.*;

public class WordLadder127 {

    // Time: O(N * (M + M^2)) = O(N * M^2)
    // N: number of words in wordList, M: length of word
    // Space: O( M^2 * N)
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        if (!set.contains(endWord)) return 0;

        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.add(beginWord);
        visited.add(beginWord);
        int changes = 1;

        while (!queue.isEmpty()) { //O(N)
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                String word = queue.poll();

                if (word.equals(endWord)) return changes; //O(M)

                for (int j = 0; j < word.length(); j++) { //O(M)
                    for (char k = 'a'; k <= 'z'; k++) { //O(1)
                        char[] arr = word.toCharArray();
                        arr[j] = k;

                        String str = new String(arr); //O(M)

                        if (set.contains(str) && !visited.contains(str)) {
                            queue.add(str);
                            visited.add(str);
                        }
                    }
                }
            }
            changes++;
        }

        return 0;
    }
}
