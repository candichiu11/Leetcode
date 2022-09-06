package BackToBackSWE.Search;

import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTwoSortedArrays349 {

    //Time: O(m + n) , m: the number of items in nums1, n: the number of items in nums2
    //Space: O(m + n)
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();

        for (int i : nums1) {
            set.add(i);
        }

        Set<Integer> result = new HashSet<>();

        for (int i : nums2) {
            if (set.contains(i)) {
                result.add(i);
            }
        }

        return setToArray(result);
    }

    private int[] setToArray(Set<Integer> set) {
        int[] array = new int[set.size()];
        int index = 0;

        for (int item : set) {
            array[index] = item;
            index++;
        }

        return array;
    }
}
