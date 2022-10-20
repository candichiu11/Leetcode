package leetcode.NeetCode150.ArraysAndHashing;

import java.util.HashMap;
import java.util.Map;

public class LongestConsecutiveSequence128 {

    // Time: O(n), n: nums.length
    // Space: O(n)
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;

        //O(n)
        Map<Integer, Boolean> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, false);
        }

        int longestLen = 0;

        //O(n)
        for (int num : nums) {
            int currLen = 1;
            if (map.get(num) == false) {

                map.put(num, true);
                int nextNum = num + 1;
                while (map.containsKey(nextNum) && map.get(nextNum) == false) {
                    currLen++;
                    map.put(nextNum, true);
                    nextNum++;
                }

                int prevNum = num - 1;
                while (map.containsKey(prevNum) && map.get(prevNum) == false) {
                    currLen++;
                    map.put(prevNum, true);
                    prevNum--;
                }
            }

            longestLen = Math.max(longestLen, currLen);
        }

        return longestLen;
    }
}
