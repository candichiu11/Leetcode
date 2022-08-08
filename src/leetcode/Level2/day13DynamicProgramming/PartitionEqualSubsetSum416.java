package leetcode.Level2.day13DynamicProgramming;


public class PartitionEqualSubsetSum416 {

    //Time: O(n*m) n: the number of nums array, m: the target sum
    //Space: O(n*m) the 2d array dp, size: (n*m)
    public boolean canPartition(int[] nums) {
        int numsLen = nums.length;
        int sum = 0;

        for(int i: nums) {
            sum += i;
        }

        if(sum % 2 != 0) return false;
        int target = sum/2;

        boolean[][] dp = new boolean[numsLen + 1][target+1];
        dp[0][0] = true;
        for(int i = 1; i < numsLen + 1; i++) {
            dp[i][0] = true;
        }

        //Transition function: For each number,
        // if we don't pick it, dp[i][j] = dp[i-1][j],
        // which means if the first i-1 elements has made it to j, dp[i][j] would also make it to j (we can just ignore nums[i]).
        // If we pick nums[i]. dp[i][j] = dp[i-1][j-nums[i]], which represents that j is composed of the current value nums[i] and the remaining composed of other previous numbers.
        // Thus, the transition function is dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i]]
        for(int i = 1; i < numsLen + 1; i++) {
            for(int j = 1; j <= target; j++) {
                if(nums[i-1] > j) {
                    dp[i][j] = dp[i-1][j];
                }

                if(nums[i-1] <= j) {
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i-1]];
                }
            }
        }

        return dp[numsLen][target];

    }

    public static void main(String[] args) {
        PartitionEqualSubsetSum416 test = new PartitionEqualSubsetSum416();
        int[] nums = {1,5,11,5};
        test.canPartition(nums);
    }

}
