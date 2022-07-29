package leetcode.Level2.day11GraphBFSDFS;

import java.util.Arrays;

public class CourseScheduleII210 {

    public int[] findOrder(int numsCourse, int[][] prerequisite) {
        int[] course = new int[numsCourse];

        for(int i = 0; i < prerequisite.length; i++) {
            course[prerequisite[i][1]]++;
        }

        boolean[] visited = new boolean[prerequisite.length];
        boolean flag = true;
        int[] result = new int[numsCourse];
        int i=0;

        while(flag) {
            flag = false;
            for(int j = 0; j < prerequisite.length; j++) {
                if(!visited[j]) {
                    if(course[prerequisite[j][0]] == 0) {
                        visited[j] = true;
                        course[prerequisite[j][1]]--;
                        flag = true;
                    }
                }
            }
        }

        for(int k = 0; k < numsCourse; k++) {
            if(course[k] != 0) return new int[]{};
        }

        System.out.println(Arrays.toString(result));
        return result;
    }

    public static void main(String[] args) {
        CourseScheduleII210 test = new CourseScheduleII210();
        int numsCourse = 4;
        int[][] prerequisite = {{1,0},{2,0},{3,1},{3,2}};
        test.findOrder(numsCourse, prerequisite);
    }

}
