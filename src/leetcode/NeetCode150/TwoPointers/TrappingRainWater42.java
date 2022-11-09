package leetcode.NeetCode150.TwoPointers;

public class TrappingRainWater42 {

    // Time: O(n), n: height.length
    // Space: O(n)
    public int trap(int[] height) {
        int n = height.length;
        if (n < 3) return 0;

        int maxLeft = 0;
        int[] maxLeftArr = new int[n];
        for (int i = 0; i < n; i++) {
            maxLeft = Math.max(maxLeft, height[i]);
            maxLeftArr[i] = maxLeft;
        }

        int maxRight = 0;
        int[] maxRightArr = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            maxRight = Math.max(maxRight, height[i]);
            maxRightArr[i] = maxRight;
        }

        int totalRain = 0;
        for (int i = 1; i < n - 1; i++) {
            int rainTrapped = Math.min(maxLeftArr[i], maxRightArr[i]) - height[i];
            totalRain += rainTrapped;
        }

        return totalRain;
    }

}
