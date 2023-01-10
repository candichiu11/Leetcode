package leetcode.NeetCode150.Greedy;

public class JumpGameII45 {

    // Time: O(N)
    // Space: O(1)
    public int jump(int[] nums) {
        int n = nums.length;
        int farthest = 0;
        int jumps = 0;
        int current = 0;

        for (int i = 0; i < n - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]);

            if (i == current) {
                jumps++;
                current = farthest;
            }
        }
        return jumps;
    }
}
