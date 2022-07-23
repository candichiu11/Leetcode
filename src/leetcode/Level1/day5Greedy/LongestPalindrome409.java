package leetcode.Level1.day5Greedy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LongestPalindrome409 {

    //Time: O(n) , Space: O(1),the space for our count, as the alphabet size of s is fixed.
    public int longestPalindrome(String s) {
        Map<Character, Integer> freqMap = new HashMap<>();
        for(char c: s.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) +1);
        }

        List<Integer> charOccurence = new ArrayList<>(freqMap.values());

        int result = 0;
        for(int v: charOccurence) {
            result += v/2 * 2;

            if(result%2 == 0 && v%2 == 1) {
                result += 1;
            }
        }
        System.out.println(result);
        return result;
    }

    public static void main(String[] args) {
        LongestPalindrome409 test = new LongestPalindrome409();
        test.longestPalindrome("abccccdd");
    }
}
