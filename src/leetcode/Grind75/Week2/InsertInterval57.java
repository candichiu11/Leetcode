package leetcode.Grind75.Week2;


import java.util.ArrayList;
import java.util.List;

public class InsertInterval57 {

    //Time: O(n), n: total number of intervals
    //Space: O(n)
    public int[][] insert(int[][] intervals, int[] newInterval) {
         List<int[]> result = new ArrayList<>();
         int size = intervals.length;
         int i = 0;

        //1. Add all intervals that are non-overlapping to the newInterval
          while (i < size && intervals[i][1] < newInterval[0]) {
              result.add(intervals[i++]);
          }

        //2. merge newInterval with overlapping intervals
          while (i < size && intervals[i][0] <= newInterval[1]) {
              newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
              newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
              i++;
          }
          result.add(newInterval);

        //3. add the remaining intervals onto the list
          while (i < size) {
              result.add(intervals[i++]);
          }

          return result.toArray(new int[result.size()][2]);

    }
}
