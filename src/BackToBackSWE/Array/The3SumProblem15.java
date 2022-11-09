package BackToBackSWE.Array;

import java.util.*;

public class The3SumProblem15 {

    //Time: O(n log n + n^2) --> O(n^2)
    //Space: O(1) ignore the output list array
    public List<List<Integer>> threeSum(int[] A){

        Set<List<Integer>> result = new HashSet<>();
        int secondToLastIndex = A.length - 2;

        for (int i = 0; i < secondToLastIndex; i++) {
            findTwoSum(i, A,result);
        }

        return new ArrayList<>(result);
    }

    //HashSet doesn't allow duplicate values.
    private void findTwoSum(int root, int[] A, Set<List<Integer>> result) {
        Arrays.sort(A); //O(n log n)

        int left = root + 1;
        int right = A.length - 1;

        //O(n)
        while (left < right) {
            int threeNumberSum = A[root] + A[left] + A[right];

            if(threeNumberSum == 0) {
                List<Integer> partial = new ArrayList<>();
                partial.add(A[root]);
                partial.add(A[left]);
                partial.add(A[right]);
                result.add(partial);
                left++;
                right--;
            } else if (threeNumberSum < 0) {
                left++;
            } else {
                right--;
            }
        }
    }

    public static void main(String[] args) {
        The3SumProblem15 test = new The3SumProblem15();
        int[] A = {-3, -1, 1, 0, 2, 10, -2, 8};
        test.threeSum(A);
    }

}
