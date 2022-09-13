package leetcode.Grind75.Week1;

import java.util.HashMap;
import java.util.Map;

public class TwoSum1 {

    //Time: O(n)
    //Space: O(n)
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int curr = nums[i];
            int x = target - curr;

            if (map.containsKey(x)) {
                return new int[] {map.get(x), i};
            }

            map.put(curr, i);
        }
        return null;
    }
}
