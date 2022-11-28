package leetcode.NeetCode150.OneDDynamicProgramming;

public class PalindromicSubstrings647 {

    // Time: O(n^2)
    // Space: O(1)
    public int countSubstrings(String s) {
        if (s.length() == 1) return 1;

        int n = s.length();
        int count = 0;

        for (int i = 0; i < n; i++) {
            int low = i;
            int high = i;

            while (s.charAt(low) == s.charAt(high)) {
                count++;
                low--;
                high++;

                if (low == -1 || high == n) break;
            }
        }

        for (int j = 1; j < n; j++) {
            int low = j - 1;
            int high = j;

            while (s.charAt(low) == s.charAt(high)) {
                count++;
                low--;
                high++;

                if (low == -1 || high == n) break;
            }

        }


        return count;
    }
}
