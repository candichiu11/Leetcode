package leetcode.Grind75.Week2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ContainsDuplicate217 {

    //Time: O(n) n: number of items in the array
    //Space: O(n)
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);
        }

        return false;
    }

    public static void main(String[] args) {
        ContainsDuplicate217 test = new ContainsDuplicate217();
        int[] nums = {1,2,3,4};
        System.out.println(test.containsDuplicate(nums));
    }
}
