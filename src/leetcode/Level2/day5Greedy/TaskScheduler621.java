package leetcode.Level2.day5Greedy;

import java.util.Arrays;

public class TaskScheduler621 {

    //Time: O(N) N: total number of tasks to execute
    //Space: O(1) to keep the array frequencies of 26 elements
    public int leastInterval(char[] tasks, int n) {
        int[] frequencies = new int[26];
        for(int task: tasks) {
            frequencies[task - 'A']++;
        }

        //We sort an array frequencies which contains 26 characters, it takes constant time.
        Arrays.sort(frequencies);
        int fMax = frequencies[25];
        int idleTime = (fMax-1) * n;

        for(int i= frequencies.length-2; i>=0; i--) {
            idleTime = idleTime - Math.min(fMax -1, frequencies[i]);
        }

        return idleTime >0 ? idleTime+tasks.length : tasks.length;
    }

   public static void main(String[] args) {
        TaskScheduler621 test = new TaskScheduler621();
       char[] tasks = {'A','A','A','B','B','B'};
        test.leastInterval(tasks, 2);
   }
}
