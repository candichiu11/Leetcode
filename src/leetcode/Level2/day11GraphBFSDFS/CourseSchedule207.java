package leetcode.Level2.day11GraphBFSDFS;

import java.util.*;

public class CourseSchedule207 {
    // https://leetcode.com/problems/course-schedule-ii/discuss/190393/Topological-Sort-Template-General-Approach!!
    //Time: O(V + E), V: the number of courses, E: the number of prerequisite
    //Space: O(V + E), we build a graph data structure for the algorithm
    public boolean canFinish(int numsCourse, int[][] prerequisite) {
        int[] indegree = new int [numsCourse];
        Map<Integer, List<Integer>> topoMap = new HashMap<>();

        for (int i = 0; i < numsCourse; i++) {
            topoMap.put(i, new ArrayList<>());
        }

        for (int[] pre : prerequisite) {
            int currCourse = pre[0];
            int preCourse = pre[1];
            topoMap.get(preCourse).add(currCourse);
            indegree[currCourse]++;
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < numsCourse; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            Integer curr = q.poll();

            for (int child : topoMap.get(curr)) {
                indegree[child]--;

                if (indegree[child] == 0) {
                    q.add(child);
                }
            }

        }

        for (int i = 0; i < numsCourse; i++) {
            if (indegree[i] != 0) {
                return false;
            }

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
