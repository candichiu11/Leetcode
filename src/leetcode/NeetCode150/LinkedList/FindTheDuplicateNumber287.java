package leetcode.NeetCode150.LinkedList;

public class FindTheDuplicateNumber287 {

    public int findDuplicate(int[] nums) {
          int slow = 0;
          int fast = 0;
          int n = nums.length;

          while (fast != n) {
              slow = nums[slow];
              fast = nums[nums[fast]];

              if (slow == fast) {
                  fast = 0;
                  break;
              }
          }

          if (fast == 0) {
              while (slow != fast) {
                  slow = nums[slow];
                  fast = nums[fast];
              }

              return slow;
          }
          return -1;
    }
}
