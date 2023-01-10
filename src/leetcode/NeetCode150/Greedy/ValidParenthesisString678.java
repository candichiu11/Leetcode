package leetcode.NeetCode150.Greedy;

import java.util.Stack;

public class ValidParenthesisString678 {

    // Time: O(N)
    // Space: O(N)
    public boolean checkValidString(String s) {
        int n = s.length();
        Stack<Integer> left = new Stack<>();
        Stack<Integer> star = new Stack<>();

        // (()*
        //left:
        //star:
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                left.push(i);
            } else if (s.charAt(i) == ')') {
                if (!left.isEmpty()) {
                    left.pop();
                } else if (!star.isEmpty()) {
                    star.pop();
                } else {
                    return false;
                }
            } else {
                star.push(i);
            }
        }

        while (!left.isEmpty() && !star.isEmpty()) {
            int leftIndex = left.pop();
            int starIndex = star.pop();
            if (starIndex < leftIndex) {
                return false;
            }
        }

        return left.isEmpty();
    }
}
