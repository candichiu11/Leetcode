package leetcode.Grind75.Week2;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters3 {

    // Time: O(N) N = s.length()
    // Space: O(N)
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        int i = 0, j = 0, maxLen = 0;
        Set<Character> seen = new HashSet<>();

        while (i < s.length()) {
            char c = s.charAt(i);

            while (seen.contains(c)) {
                seen.remove(s.charAt(j));
                j++;
            }

            seen.add(c);
            maxLen = Math.max(maxLen, i - j + 1);
            i++;
        }

        return maxLen;
    }
}
