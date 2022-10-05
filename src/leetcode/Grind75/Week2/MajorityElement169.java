package leetcode.Grind75.Week2;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement169 {

    //Time: O(n)
    //Space: O(n)
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }

        Map.Entry<Integer, Integer> majorityEntry = null;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {

            if (majorityEntry == null || entry.getValue() > majorityEntry.getValue()) {
                    majorityEntry = entry;
            }

        }

        return majorityEntry.getKey();
    }

    public static void main(String[] args) {
        MajorityElement169 test = new MajorityElement169();
        int[] nums = {3,2,3};
        System.out.println(test.majorityElement(nums));
    }
}
