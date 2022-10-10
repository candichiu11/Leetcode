package BackToBackSWE.RecursionAndBacktracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses22 {

    //Time: ?
    //Space: O(n), recursion tree, height is 2 * n, O(2n) ~= O(n)
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generate(n, n, "", result);
        return result;
    }

    private void generate(int left, int right, String partialResult, List<String> result) {
        //base
        if (left == 0 && right == 0) {
            result.add(partialResult);
            return;
        }

        /*
        If you change the input parameter type String to StringBuilder as follow,
        it is explicit the solution is a typical backtracking, which has an obvious stepping back sb.deleteCharAt(sb.length() - 1);.
        I think it is String type makes backtracking implicit and lets people consider it a common DFS solution.
        In Java, String is a final type, changing a string will generate a new string,
        which disables one string's ability in memorialized searching (compared to one StringBuilder) in multilevel function calls.
        Thus in the String appoach, through generating new string (by appending a parentheses to the string int the previous function call) for memorialized searching,
        we don't need an explicit stepping back like sb.deleteCharAt(sb.length() - 1);.
         */

        if (left > 0) {
            generate(left - 1, right, partialResult + "(", result);
        }

        if (left < right) {
            generate(left, right - 1, partialResult + ")", result);
        }

    }
}
