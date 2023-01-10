package leetcode.NeetCode150.Greedy;

public class JumpGame55 {

    // Time: O(N)
    // Space: O(1)
    public boolean canJump(int[] nums) {
        int goalPost = nums.length - 1;

        for (int i = goalPost - 1; i >= 0; i--) {
            if (i + nums[i] >= goalPost) {
                goalPost = i;
            }
        }

        return goalPost == 0;
    }
}
