package leetcode.NeetCode150.SlidingWindow;


public class PermutationInString567 {

    // Time: O(n), n = s2.length
    // Space: O(1), arrays are fixed size. O(26)
    public boolean checkInclusion(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();

        if (n2 < n1) return false;

        int[] arr1 = new int[26];
        int[] arr2 = new int[26];

        for (int i = 0; i < n1; i++) {
            arr1[s1.charAt(i) - 'a']++;
            arr2[s2.charAt(i) - 'a']++;
        }

        for (int i = 0; i < n2 - n1; i++) {
            if (isPermutation(arr1, arr2)) {
                return true;
            }

            arr2[s2.charAt(i)]--;
            arr2[s2.charAt(i + n1)]++;
        }

        if (isPermutation(arr1, arr2)) {
            return true;
        }
        return false;
    }

    private boolean isPermutation(int[] arr1, int[] arr2) {
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

}
