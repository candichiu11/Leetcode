package BackToBackSWE.Search;

import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTwoSortedArrays349 {

    //Time: O(m + n) , m: the number of items in num1, n: the number of items in num2
    //Space: O(1)
    public int[] intersection(int[] num1, int[] num2) {
        Set<Integer> set = new HashSet<>();
        int pointer1 = 0;
        int pointer2 = 0;

        while (pointer1 < num1.length && pointer2 < num2.length) {
            if (num1[pointer1] == num2[pointer2]) {
                set.add(num1[pointer1]);
                pointer1++;
                pointer2++;
            } else if (num1[pointer1] < num2[pointer2]){
                pointer1++;
            } else {
                pointer2++;
            }
        }
         return setToArray(set);
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
