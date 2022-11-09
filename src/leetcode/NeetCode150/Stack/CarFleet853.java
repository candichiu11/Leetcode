package leetcode.NeetCode150.Stack;

import java.util.Arrays;
import java.util.Stack;

public class CarFleet853 {

    // Time: O(n * log n)
    // Space: O(n)
    public int carFleet(int target, int[] position, int[] speed) {
        int p = position.length;
        if (p == 1) return 1;

        int[][] combine = new int[p][2];

        for (int i = 0; i < p; i++) {
            combine[i][0] = position[i];
            combine[i][1] = speed[i];
        }

        //O(n* log n)
        //Arrays.sort(combine, (a, b) -> Integer.compare(a[0], b[0]));
        Arrays.sort(combine, (a, b) -> (a[0] - b[0])); //ascending order

        Stack<Double> stack = new Stack<>();

        for (int i = combine.length - 1; i >= 0; i++) {
            double timeToDestination = (double) (target - combine[i][0]) / combine[i][1];

            if (!stack.isEmpty() && timeToDestination <= stack.peek()) {
                continue;
            } else {
                stack.push(timeToDestination);
            }
        }
        return stack.size();
    }
}
