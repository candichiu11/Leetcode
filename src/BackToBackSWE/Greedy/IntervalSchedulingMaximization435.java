package BackToBackSWE.Greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class IntervalSchedulingMaximization435 {

    public List<int[]> constructOptimalSchedule(int[][] intervals) {
        List<int[]> optimalSchedule = new ArrayList<>();
        Arrays.sort(intervals, new TwoDimArrayCompare());

        if (intervals.length == 0) return optimalSchedule;
        int lastActiveScheduleEnd = Integer.MIN_VALUE;

        for (int[] interval : intervals) {
            int start = interval[0];
            int end = interval[1];

            if (start >= lastActiveScheduleEnd) {
               optimalSchedule.add(interval);
               lastActiveScheduleEnd = end;
            }
        }

        return optimalSchedule;
    }

    class TwoDimArrayCompare implements Comparator<int[]> {
        public int compare(int[] a, int[] b) {
            return a[1] - b[1];
        }
    }
}
