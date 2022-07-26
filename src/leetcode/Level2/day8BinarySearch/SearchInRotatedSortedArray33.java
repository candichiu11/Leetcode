package leetcode.Level2.day8BinarySearch;

public class SearchInRotatedSortedArray33 {

    //Time: O(logN), Space: O(1)
    public int search(int[] nums, int target) {
        int numsLength = nums.length;
        int left = 0, right = numsLength - 1;

        while (left<=right) {
            int pivot = left + (right-left)/2;
            if(nums[pivot] == target) {
                return pivot;
            }

            //nums = [4,5,6,7,0,1,2]
            if(nums[left]<=nums[pivot]) {
                if(target >= nums[left] && target < nums[pivot]) {
                    right = pivot - 1;
                } else {
                    left = pivot + 1;
                }
            } else {
                //nums = [6,7,0,1,2,3,4]
                if(target > nums[pivot] && target <= nums[right]) {
                    left = pivot + 1;
                } else {
                    right = pivot - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
            SearchInRotatedSortedArray33 test = new SearchInRotatedSortedArray33();
            int[] nums = {4,5,6,7,0,1,2};
            test.search(nums, 0);
    }

}
