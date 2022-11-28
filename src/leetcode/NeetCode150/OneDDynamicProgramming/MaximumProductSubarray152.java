package leetcode.NeetCode150.OneDDynamicProgramming;

public class MaximumProductSubarray152 {

    // Time: O(N)
    // Space: O(1), we only use three variables to track result
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int maxSoFar = nums[0];
        int minSoFar = nums[0];
        int res = nums[0];

        for (int i = 1; i < n; i++) {
            int temp = maxSoFar;
            maxSoFar = Math.max(nums[i], Math.max(maxSoFar * nums[i], minSoFar * nums[i]));
            minSoFar = Math.min(nums[i], Math.min(temp * nums[i], minSoFar * nums[i]));
            res = Math.max(res, maxSoFar);
        }

        return res;
    }
}
