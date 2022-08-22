package BackToBackSWE.Stack;

import java.util.Stack;

public class TheBalancedParenthesesProblem20 {

    //Time: O(n), n: number of characters in the string
    //Space: O(n), worst case
    public boolean isValid(String s) {
        Stack<Character> leftChars = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                leftChars.push(s.charAt(i));
            } else {
                if (leftChars.isEmpty()) return false;

                if (s.charAt(i) == ')' && leftChars.peek() != '(' ||
                    s.charAt(i) == '}' && leftChars.peek() != '{' ||
                    s.charAt(i) == ']' && leftChars.peek() != '[') {
                    return false;
                }
                leftChars.pop();
            }
        }

        return leftChars.isEmpty();

    }
}
