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

    /*
    // Use Heap + HashMap
    // Time: O(N * log N) N: tasks.length
    // Space: O(N)
    public int leastInterval(char[] tasks, int n) {
        if (n == 0) return tasks.length;

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> (b - a));
        Map<Integer, Integer> map = new HashMap<>();

        int[] freq = new int[26];

        for (char task : tasks) {  // O(N)
            freq[task - 'A']++;
        }

        for (int f : freq) {  // O(26)
            if (f > 0) {
             maxHeap.add(f); // O(N * log N)
            }
        }

        int time = 0;
        int curr = 0;
        while (!maxHeap.isEmpty() || !map.isEmpty()) {
           if(!maxHeap.isEmpty()) {
               curr = maxHeap.poll();
               if (curr > 1) {
                map.put(time + n + 1, curr - 1);
            }
           }

            time++;


            if (map.containsKey(time)) {
                    maxHeap.add(map.get(time));
                    map.remove(time);
            }



        }
        return time;

    }
     */



   public static void main(String[] args) {
        TaskScheduler621 test = new TaskScheduler621();
       char[] tasks = {'A','A','A','B','B','B'};
        test.leastInterval(tasks, 2);
   }
}
