package leetcode.Grind75.Week1;

public class BinarySearch704 {

    //Time: O(log n)
    //Space: O(1)
    public int search(int[] nums, int target) {
        int len = nums.length;
        int left = 0;
        int right = len - 1;

        while (left <= right) {
            int mid = left + (right - left)/2;
            if (nums[mid] == target) {
                return mid;
            }

            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }

        }
       return -1;
    }

    public static void main(String[] args) {
        BinarySearch704 test = new BinarySearch704();
        int[] nums = {-1};
        System.out.println(test.search(nums, -1));
    }
}
