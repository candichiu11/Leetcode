package leetcode.Grind75.Week2;

public class MaximumSubarray53 {

    //Time: O(n), n: nums.length
    //Space: O(1)
    public int maxSubArray(int[] nums) {
        int maxEndingHere = nums[0];
        int maxSoFar = nums[0];

        for (int i = 1; i < nums.length; i++) {
           maxEndingHere = Math.max(maxEndingHere + nums[i], nums[i]);
           maxSoFar = Math.max(maxSoFar, maxEndingHere);

        }
        return maxSoFar;
    }

    public static void main(String[] args) {
        MaximumSubarray53 test = new MaximumSubarray53();
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(test.maxSubArray(nums));
    }
}
