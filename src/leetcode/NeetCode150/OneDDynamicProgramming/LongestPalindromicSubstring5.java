package leetcode.NeetCode150.OneDDynamicProgramming;

public class LongestPalindromicSubstring5 {

    // Time: O(N^2)
    // Space: O(1)
    public String longestPalindrome(String s) {
        int n = s.length();
        if (n < 2) return s;
        String longest = "";

        for (int i = 1; i < n; i++) {
            // Odd length
            int low = i;
            int high = i;

            while (s.charAt(low) == s.charAt(high)) {
                low--;
                high++;

                if (low == -1 || high == n) {
                    break;
                }
            }
            String sub = s.substring(low + 1, high);
            System.out.println(sub);
            if (sub.length() > longest.length()) {
                longest = sub;
            }


            // Even length
            low = i - 1;
            high = i;

            while (s.charAt(low) == s.charAt(high)) {
                low--;
                high++;

                if (low == -1 || high == n) {
                    break;
                }
            }

            sub = s.substring(low + 1, high);
            System.out.println(sub);
            if (sub.length() > longest.length()) {
                longest = sub;
            }


        }
        return longest;
    }
}
