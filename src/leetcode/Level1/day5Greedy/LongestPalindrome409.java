package leetcode.Level1.day5Greedy;


import java.util.HashMap;
import java.util.Map;

public class LongestPalindrome409 {

    // Time: O(n), n: length of string s
    // Space: O(n) the hashmap created to store character occurrences
    public int longestPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();

        // O(n)
        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        int result = 0;
        boolean oddFound = false;
        //O(n)
        for (int i : map.values()) {
            if (i % 2 == 0) {
                result += i;
            } else {
                oddFound = true;
                result += (i - 1);
            }
        }
        if (oddFound) {
            result += 1;
        }

        return result;
    }

    public static void main(String[] args) {
        LongestPalindrome409 test = new LongestPalindrome409();
        System.out.println(test.longestPalindrome("abccccdd"));
    }
}
