package leetcode.NeetCode150.BinarySearch;

public class KokoEatingBananas875 {

    // Time: O(n* log max)
    // Space: O(1)
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        int max = 0;

        for (int i = 0; i < n; i++) {
            max = Math.max(max, piles[i]);
        }

        int l = 1, r = max;
        int minSpeed = Integer.MAX_VALUE;

        //O(log max)
        while (l <= r) {
            int mid = l + (r - l)/2;
            int days = 0;
            //O(n)
            for (int pile : piles) {
                if (pile <= mid) {
                    days += 1;

                } else if (pile % mid == 0){
                    days += pile/mid;

                } else {
                    days += (pile / mid) + 1;
                }
            }

            if (days <= h) {
                minSpeed = Math.min(minSpeed, mid);
                r = mid - 1;
            } else {
                l = mid + 1;
            }

        }
        return minSpeed;

    }
}
