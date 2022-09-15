package leetcode.Grind75.Week1;

public class ValidAnagram242 {

    //Time: O(n)
    //Space: O(26) = O(1)
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] occurance = new int[26];

        for (char c : s.toCharArray()) {
            occurance[c - 'a']++;
        }

        for (char c : t.toCharArray()) {
            if (occurance[c - 'a'] == 0) return false;
            occurance[c - 'a']--;
        }

        return true;
    }

}
