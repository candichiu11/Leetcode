package leetcode.Level2.day8BinarySearch;

public class SearchA2DMatrix74 {

    //Time: O(log(mn)), it's a standard banary search
    //Space: O(1)
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int left=0, right=m*n-1;

        while(left <= right) {
            int pivot = (left+right)/2;
            int pivotElement = matrix[pivot / n][pivot % n];
            if(pivotElement == target) {
                return true;
            }

            if(pivotElement > target) {
                right = pivot - 1;
            } else {
                left = pivot + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,3,5,7},
                          {10,11,16,20},
                          {23,30,34,60}};
        SearchA2DMatrix74 test = new SearchA2DMatrix74();
        test.searchMatrix(matrix, 3);
    }
}
