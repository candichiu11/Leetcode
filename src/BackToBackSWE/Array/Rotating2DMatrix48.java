package BackToBackSWE.Array;

public class Rotating2DMatrix48 {

    //Time: O(n^2)
    //Space: O(1)
    public int[][] rotate(int[][] matrix) {
        int sizeLastIndex = matrix.length - 1;
        int totalLayer = matrix.length / 2;

        for (int layer = 0; layer < totalLayer; layer++) {
            for (int i = layer; i < sizeLastIndex - layer; i++) {
                int top = matrix[layer][i];
                int right = matrix[i][sizeLastIndex - layer];
                int bottom = matrix[sizeLastIndex - layer][sizeLastIndex - i];
                int left = matrix[sizeLastIndex - i][layer];

                matrix[layer][i] = left;
                matrix[i][sizeLastIndex - layer] = top;
                matrix[sizeLastIndex - layer][sizeLastIndex - i] = right;
                matrix[sizeLastIndex - i][layer] = bottom;
            }
        }
        return matrix;
    }
}
