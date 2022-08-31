package BackToBackSWE.DynamicProgramming;

import java.util.Arrays;

public class ArrayProduct238 {

    //Time: O(n), n: number of items in nums array
    //Space: O(1), output array does not count
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] result = new int[len];

        //Get prefix
        result[0] = 1;
        for (int i = 1; i < len; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }

        //Get product array except self
        int suffix = 1;
        for (int j = len - 1; j >= 0; j--) {
            result[j] = result[j] * suffix;
            suffix = suffix * nums[j];
        }

        return result;
    }

    public static void main(String[] args) {
        ArrayProduct238 test = new ArrayProduct238();
        System.out.println(Arrays.toString(test.productExceptSelf(new int[]{1, 2, 3, 4})));
    }
}
