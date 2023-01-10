package leetcode.NeetCode150.BinarySearch;

public class MedianOfTwoSortedArrays4 {

    // Time: O(log min(m, n)), we do binary search on the shorter array
    // Space: O(1)
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // n2 < n1
        int n1 = nums1.length;
        int n2 = nums2.length;

        if (n1 < n2) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int total = n1 + n2;
        int half = total/2;
        double mid = 0.00;
        int l = 0, r = n2;

        while (l <= r) {
            int n2Left = (l + r)/2;
            int n1Left = half - n2Left;

            int left1 = n1Left > 0 ? nums1[n1Left - 1] : Integer.MIN_VALUE;
            int right1 = n1Left < n1 ? nums1[n1Left] : Integer.MAX_VALUE;
            int left2 = n2Left > 0 ? nums2[n2Left -1] : Integer.MIN_VALUE;
            int right2 = n2Left < n2 ? nums2[n2Left] : Integer.MAX_VALUE;

            if (left1 <= right2 && left2 <= right1) {
                if (total % 2 != 0) {
                    mid = Math.min(right1, right2);
                } else {
                    mid = (Math.max(left1, left2) + Math.min(right1, right2))/2.0;
                }
                break;

            } else if (left1 > right2) {
                l = n2Left + 1;
            } else {
                r = n2Left - 1;
            }

        }

        return mid;
    }
}
