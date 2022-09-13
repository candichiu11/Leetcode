package BackToBackSWE.Search;

public class SearchA2DSortedMatrix240 {

    //Time: O(m + n)
    //Space: O(1)
    public boolean search(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int row = 0;
        int col = n - 1;

        while (row < m && col >= 0) {
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] > target) {
                col--;
            } else {
                row++;
            }

        }
        return false;
    }

}
