package leetcode.Level2.day11GraphBFSDFS;

import java.util.*;

public class CourseSchedule207 {

    //Time: O(V+E), V: the number of courses, E: the number of prerequisite
    //Space: O(V+E), we build a graph data structure for the algorithm
    public boolean canFinish(int numsCourse, int[][] prerequisite) {
         int[] courseDependencyCount = new int[numsCourse];

         for(int[] pre : prerequisite) {
               int currentCourse = pre[0];
               courseDependencyCount[currentCourse]++;
           }

         Set<Integer> hs = new HashSet<>();
         //Find the course that there is no incoming edges, and add it to hash set
         for(int i = 0; i< numsCourse; i++) {
             if(courseDependencyCount[i] == 0) {
                 hs.add(i);
             }
         }

         if(hs.isEmpty()) return false;

         while(!hs.isEmpty()) {
             Iterator<Integer> it = hs.iterator();
             Integer element = it.next();

             //Remove edges that element has
             for(int i = 0; i< prerequisite.length; i++) {
                 int dependentCourse = prerequisite[i][1];
                 int currCourse = prerequisite[i][0];

                 if(element == dependentCourse) {
                     courseDependencyCount[currCourse]--;

                     if(courseDependencyCount[currCourse] == 0) {
                         hs.add(currCourse);
                     }
                 }
             }
             hs.remove(element);
         }

         for(int i = 0; i < numsCourse; i++) {
             if(courseDependencyCount[i] != 0) return false;
         }
         return true;
    }




    //Time: O(V+E), V: the number of courses, E: the number of prerequisite
    //Space: O(V+E), we build a graph data structure for the algorithm
//    public boolean canFinish(int numsCourse, int[][] prerequisite) {
//
//        int[] course = new int[numsCourse];
//
//        for(int i = 0; i < prerequisite.length; i++) {
//            course[prerequisite[i][1]]++;
//        }
//
//        boolean[] visited = new boolean[prerequisite.length];
//        boolean flag = true;
//
//        while (flag) {
//            flag = false;
//            for(int j = 0; j < prerequisite.length; j++) {
//                if(!visited[j]) {
//                    if(course[prerequisite[j][0]] == 0) {
//                        visited[j] = true;
//                        course[prerequisite[j][1]]--;
//                        flag = true;
//                    }
//                }
//            }
//        }
//
//        for(int k = 0; k < numsCourse; k++) {
//            if(course[k] != 0) return false;
//        }
//       return true;
//    }

    public static void main(String[] args) {
        CourseSchedule207 test = new CourseSchedule207();
        int numsCourse = 4;
        int[][] prerequisite = {{1,0},{2,0},{3,1},{3,2}};
        test.canFinish(numsCourse, prerequisite);
    }

}
