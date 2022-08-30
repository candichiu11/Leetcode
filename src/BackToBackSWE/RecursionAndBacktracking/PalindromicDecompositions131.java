package BackToBackSWE.RecursionAndBacktracking;

import java.util.ArrayList;
import java.util.List;

public class PalindromicDecompositions131 {

    //Time: O(n * log 2^n) n: the length of string s
    //Space: O(n), maximum depth of recursion call is n
    public List<List<String>> partition(String s) {
       List<List<String>> result = new ArrayList<>();
       List<String> partialResult = new ArrayList<>();
       decomposeString(0, partialResult, result, s);

       return result;
    }

    private void decomposeString(int workingIndex, List<String> partialResult,
                                 List<List<String>> result, String s) {
        //base case:
        if (workingIndex == s.length()) {
            result.add(new ArrayList<>(partialResult));
        }

        for (int i = workingIndex; i < s.length(); i++) {
            if (isPalindrome(workingIndex, i, s)) {

                //Choose- Take the snippet and add it to partialResult
                String partial = s.substring(workingIndex, i + 1);
                partialResult.add(partial);

                //Explore: recurse
                decomposeString(i + 1, partialResult, result, s);

                //Unchoose: We are done searching, remove the snippet from our
                //          'path'. Next loop iteration will try another snippet in this stack
                //          frame.
                partialResult.remove(partialResult.size() - 1);
            }
        }
    }

    private boolean isPalindrome(int left, int right, String s) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        PalindromicDecompositions131 test = new PalindromicDecompositions131();
        System.out.println(test.partition("aab"));
    }
}
