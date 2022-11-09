package leetcode.NeetCode150.Stack;

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperatures739 {

    // Time: O(n), n: temperatures.length;
    /*
    For each temperature, you can at most push once and pop once.
    Therefore there are at most 2n operations to the stack totally.
    So the amortized time complexity is constant.

    Actually, there are n operations at most of push(i)，
    but the while loop doesn't execute every time when iterating the i,
    there are at most （n-1) operations of the pop operation and the assign operation.
     */
    // Space: O(n), stack
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] ans = new int[n];
        ans[n - 1] = 0;

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                Integer curr = stack.pop();
                ans[curr] = i - curr;

            }
            stack.push(i);
        }

        return ans;
    }

    public static void main(String[] args) {
        DailyTemperatures739 test = new DailyTemperatures739();
        int[] temp = {73,74,75,71,69,72,76,73};
        System.out.println(Arrays.toString(test.dailyTemperatures(temp)));
    }
}
