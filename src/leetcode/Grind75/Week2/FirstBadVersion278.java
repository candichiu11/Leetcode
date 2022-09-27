package leetcode.Grind75.Week2;

public class FirstBadVersion278 {

    // Time: O(log n) Binary search
    // Space: O(1)
    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }

        }
        return left;

    }

    //dummy method
    private boolean isBadVersion(int n) {
        return true;
    }
}
