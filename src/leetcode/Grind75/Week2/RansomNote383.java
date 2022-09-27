package leetcode.Grind75.Week2;

import java.util.HashMap;
import java.util.Map;

public class RansomNote383 {

    // Time: O(n) m: ransomNote.length(), n: magazine.length()
    // because n >= m, time complexity can be simplified as O(n)
    // Space: O(k) / O(1)
    // because k is never more than 26, which is a constant,
    // it'd be reasonable to say that this algorithm requires O(1) space.
    public boolean canConstruct(String ransomNote, String magazine) {
        int ransomLen = ransomNote.length();
        int magazineLen = magazine.length();
        Map<Character, Integer> map = new HashMap<>();

        //The basic HashMap operations, get(...) and put(...), are O(1) time complexity.
        //O(n)
        for (char c : magazine.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }

        //O(m)
        for (int i = 0; i < ransomLen; i++) {
            if (!map.containsKey(ransomNote.charAt(i))) {
                return false;
            }

            if (map.get(ransomNote.charAt(i)) > 0) {
                map.put(ransomNote.charAt(i), map.get(ransomNote.charAt(i)) - 1);
            } else {
                return false;
            }
        }
        return true;
    }
}
