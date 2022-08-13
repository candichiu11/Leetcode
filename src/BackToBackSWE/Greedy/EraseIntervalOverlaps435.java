package BackToBackSWE.Greedy;

import java.util.Arrays;
import java.util.Comparator;

public class EraseIntervalOverlaps435 {

    //Time: O(n* log n)
    //Space: O(1)
    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals.length == 0) return 0;

        //O(n* log n)
        Arrays.sort(intervals, new TwoDimArrayComparator());

        //O(1)
        int endActiveInterval = intervals[0][1];
        int totalNumberOfNonOverlapIntervals = 1;

        //O(n)
        for(int i = 1; i < intervals.length; i++) {
            int[] interval = intervals[i];
            int start = interval[0];
            int end = interval[1];

            if(start >= endActiveInterval) {
                endActiveInterval = end;
                totalNumberOfNonOverlapIntervals++;
            }

        }

        //O(1)
        return intervals.length - totalNumberOfNonOverlapIntervals;

    }

    class TwoDimArrayComparator implements Comparator<int[]> {
        public int compare(int[] a, int[] b) {
            return a[1] - b[1];
        }
    }

}
