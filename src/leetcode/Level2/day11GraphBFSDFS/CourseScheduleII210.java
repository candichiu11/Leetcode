package leetcode.Level2.day11GraphBFSDFS;


import java.util.*;

public class CourseScheduleII210 {

    // Time: O(V + E)
    // Space: O(V + E)
    public int[] findOrder(int numsCourse, int[][] prerequisite) {
         Map<Integer, Integer> indegree = new HashMap<>();
         Map<Integer, List<Integer>> topoMap = new HashMap<>();

         for (int i = 0; i < numsCourse; i++) {
             indegree.put(i, 0);
             topoMap.put(i, new ArrayList<>());
         }

         for (int[] pre : prerequisite) {
             int currCourse = pre[0];
             int preCourse = pre[1];
             topoMap.get(preCourse).add(currCourse);
             indegree.put(currCourse, indegree.get(currCourse) + 1);
         }


         int[] result = new int[numsCourse];
         int index = 0;

         while (!indegree.isEmpty()) {
             boolean hasCycle = true;
             for (int course : indegree.keySet()) {
                 if (indegree.get(course) == 0) {
                     result[index++] = course;

                     for (int children : topoMap.get(course)) {
                         indegree.put(children, indegree.get(children) - 1);
                     }

                     indegree.remove(course);
                     hasCycle = false;
                     break;
                 }
             }
             if (hasCycle) {
                 return new int[0];
             }
         }

         return result;

    }

    public static void main(String[] args) {
        CourseScheduleII210 test = new CourseScheduleII210();
        int numsCourse = 4;
        int[][] prerequisite = {{1,0},{2,0},{3,1},{3,2}};
        System.out.println(Arrays.toString(test.findOrder(numsCourse, prerequisite)));
    }

}
