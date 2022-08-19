package BackToBackSWE.String;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LongestPalindromeConstruction409 {

    //Time: O(n), n: the length of string s
    //Space: O(1) , size s is fixed.
    public int longestPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int result = 0;

        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }

        List<Integer> occurance = new ArrayList<>(map.values());
        for (int v : occurance) {
            result += v/2 *2;

            if (result % 2 == 0 && v % 2 == 1) {
                result += 1;
            }
        }
        return result;
    }
}
