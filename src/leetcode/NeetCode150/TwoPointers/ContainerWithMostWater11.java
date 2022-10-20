package leetcode.NeetCode150.TwoPointers;

public class ContainerWithMostWater11 {

    // Time: O(n), n: height.length
    // Space: O(1)
    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int max = 0;

        while (l < r) {
            int area = Math.min(height[l], height[r]) * (r - l);

            if (height[l] < height[r]) {
                l++;

            } else if (height[l] > height[r]) {
                r--;

            } else {
                l++;
                r--;
            }

            max = Math.max(max, area);
        }

        return max;
    }
}
