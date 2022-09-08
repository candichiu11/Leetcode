package BackToBackSWE.HashMap;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithAtMostKCharacters340 {

    //Time: O(n) n : s.length()
    //Space: O(k) hashmap always remains size k
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        //base
        if (k == 0) return 0;

        //define two pointers, hashmap, maxLen, convert string s to char array
        int l = 0, r = 0;
        Map<Character, Integer> map = new HashMap<>();
        int maxLen = 0;
        char[] charArray = s.toCharArray();

        while (r < s.length()) {

            if (!map.containsKey(charArray[r])) {
                map.put(charArray[r], 1);
            } else {
                map.put(charArray[r], map.get(charArray[r]) + 1);
            }

            if (map.size() > k) {

                if (map.get(charArray[l]) == 1) {
                    map.remove(charArray[l]);
                } else {
                    map.put(charArray[l], map.get(charArray[l]) - 1);
                }

                l++;
            }
            maxLen = Math.max(maxLen, r - l + 1);
            r++;

        }
        return maxLen;

    }

    public static void main(String[] args) {
        LongestSubstringWithAtMostKCharacters340 test = new LongestSubstringWithAtMostKCharacters340();
        System.out.println(test.lengthOfLongestSubstringKDistinct("eceba", 2));
    }
}
