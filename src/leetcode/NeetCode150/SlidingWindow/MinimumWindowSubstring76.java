package leetcode.NeetCode150.SlidingWindow;

public class MinimumWindowSubstring76 {

    // Time: O(n), n = sLen
    // Space: O(128)~= O(1)
    public String minWindow(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();
        int[] tArr = new int[128];

        //Set up the table
        for (char c : t.toCharArray()) {
            tArr[c]++;
        }

        int l = 0, r =0;
        int count = 0;
        int minLen = Integer.MAX_VALUE;
        String ans = "";

        while (r < sLen) {
            //Expand the window (r++)
            Character rightChar = s.charAt(r);
            tArr[rightChar]--;
            if (tArr[rightChar] >= 0) {
                count++;
            }

            //Shrink the window if current window contains all the char in t (l++)
            while (count == tLen) {
                int currLen = r - l + 1;
                if (currLen < minLen) {
                    minLen = currLen;
                    ans = s.substring(l, r + 1);
                }

                //Shrink the window
                Character leftChar = s.charAt(l);
                tArr[leftChar]++;
                if (tArr[leftChar] > 0) {
                    count--;
                }

                l++;
            }

            r++;
        }

        return ans;
    }
}
