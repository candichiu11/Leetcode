package BackToBackSWE.Search;

public class ComputeTheIntegerSquareRoot69 {

    //Time: O(log n) binary search
    public int sqrtroot(int n) {
        long left = 1;
        long right = n;
        long ans = 1;

        while (left <= right) {
            long mid = left + (right-left)/2;

            if (mid * mid == n) {
                ans = mid;
                return (int)ans;

            } else if (mid * mid > n) {
                right = mid - 1;
            } else {
                left = mid + 1;
                ans = mid;
            }
        }
       return (int)ans;
    }
}
