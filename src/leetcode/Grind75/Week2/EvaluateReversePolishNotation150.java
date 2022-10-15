package leetcode.Grind75.Week2;

import java.util.Stack;

public class EvaluateReversePolishNotation150 {

    // Time: O(N), N = tokens.length
    // Space: O(N)
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        stack.add(Integer.parseInt(tokens[0]));
        int answer = 0;

        while (!stack.isEmpty()) {

            for (int i = 1; i < tokens.length; i++) {
                if (tokens[i].equals("+")) {
                    stack.add(stack.pop() + stack.pop());

                } else if (tokens[i].equals("-")) {
                    int a = stack.pop();
                    int b = stack.pop();
                    stack.add(b - a);

                } else if (tokens[i].equals("*")) {
                    stack.add(stack.pop() * stack.pop());

                } else if (tokens[i].equals("/")) {
                    int a = stack.pop();
                    int b = stack.pop();
                    stack.add(b / a);

                } else {
                    stack.add(Integer.parseInt(tokens[i]));
                }

            }
            answer = stack.pop();

        }

        return answer;
    }

    public static void main(String[] args) {
        EvaluateReversePolishNotation150 test = new EvaluateReversePolishNotation150();
        String[] tokens = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        System.out.println(test.evalRPN(tokens));
    }
}
