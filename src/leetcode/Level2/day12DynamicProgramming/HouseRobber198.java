package leetcode.Level2.day12DynamicProgramming;

public class HouseRobber198 {

    //Time: O(N), Space: O(N), which is used by maxMoney array.
    public int rob(int[] nums) {
        int[] maxMoney = new int[nums.length];
        maxMoney[0] = nums[0];

        if(nums.length == 1) return nums[0];
        if(nums.length == 2) return Math.max(nums[0], nums[1]);

        maxMoney[1] = Math.max(nums[0], nums[1]);

        for(int i = 2; i < nums.length; i++) {
            maxMoney[i] = Math.max(maxMoney[i-2] + nums[i], maxMoney[i-1]);
        }

        return maxMoney[nums.length-1];
    }

    public static void main(String[] args) {
        HouseRobber198 test = new HouseRobber198();
        int[] nums = {1,2,3,1};
        test.rob(nums);
    }

}
