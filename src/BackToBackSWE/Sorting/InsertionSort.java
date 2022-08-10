package BackToBackSWE.Sorting;

import java.util.Arrays;

public class InsertionSort {

    //Time: O(n^2) quadratic
    public void sort(int[] input) {
        int len = input.length;

        for (int i = 1; i < len; i++) {
            int currentValue = input[i];
            int j = i - 1;

            while(j >= 0 && input[j] > currentValue) {
                input[j+1] = input[j];
                j--;
            }
            input[j+1] = currentValue;
        }
        System.out.println(Arrays.toString(input));
    }

    public static void main(String[] args) {
        InsertionSort test = new InsertionSort();
        int[] input = {5, 1, 4, 9, 0, 2};
        test.sort(input);
    }

}
