package BackToBackSWE.DynamicProgramming;

import java.util.ArrayList;
import java.util.List;

public class MinimumWeightPathInATriangle120 {

    //Time: O(n), n: total number of items in the triangle
    //Space: O(n)
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] cache = new int[triangle.size()];

        for (int i = 0; i < cache.length; i++) {
            cache[i] = triangle.get(triangle.size() - 1).get(i);
        }

        for (int j = triangle.size() - 2; j >= 0; j--) {
            List<Integer> currentLayer = triangle.get(j);

            for (int k = 0; k < currentLayer.size(); k++) {
                int minLeft = cache[k];
                int minRight = cache[k + 1];
                int min = Math.min(minLeft, minRight);
                cache[k] = min + currentLayer.get(k);
            }
        }

        return cache[0];
    }

    public static void main(String[] args) {
        MinimumWeightPathInATriangle120 test = new MinimumWeightPathInATriangle120();
        List<List<Integer>> testData = new ArrayList<>(4);
        for(int i = 0; i < 4; i++)  {
            testData.add(new ArrayList<Integer>());
        }

        testData.get(0).add(2);
        testData.get(1).add(3);
        testData.get(1).add(4);
        testData.get(2).add(6);
        testData.get(2).add(5);
        testData.get(2).add(7);
        testData.get(3).add(4);
        testData.get(3).add(1);
        testData.get(3).add(8);
        testData.get(3).add(3);
        System.out.println(testData);
        System.out.println(test.minimumTotal(testData));
    }
}
