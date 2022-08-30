package BackToBackSWE.Sorting;

import java.util.Arrays;
import java.util.Stack;

public class MergeOverlappingIntervals56 {

    //Time: O(n*log n)
    //Space: O(n)
    public int[][] merge(int[][] intervals) {
        //base case
        if (intervals.length == 1) return intervals;

        //sort intervals by start time, ascending order
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        //define Stack
        Stack<int[]> stack = new Stack<>();

        //push the first interval onto the stack
        stack.add(intervals[0]);

        //merge intervals
        for (int i = 1; i < intervals.length; i++) {
            int[] pre = stack.peek();
           // System.out.println("pre: " + Arrays.toString(pre));
            int[] curr = intervals[i];

            if (pre[1] < curr[0]) {
                stack.add(curr);
            } else {
                pre[1] = Math.max(pre[1], curr[1]);
            }
        }

       // System.out.println(Arrays.deepToString(stack.toArray(new int[stack.size()][2])));
        //return list
        return stack.toArray(new int[stack.size()][2]);
    }

    public static void main(String[] args) {
        MergeOverlappingIntervals56 test = new MergeOverlappingIntervals56();
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        test.merge(intervals);
    }
}
