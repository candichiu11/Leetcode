package BackToBackSWE.Sorting;

import java.util.Arrays;

public class SelectionSort {

    public void sort(int[] input) {
        int len = input.length;

        for (int i = 0; i < len; i++) {
            int minValue = input[i];
            int minIndex = i;

            for (int j = i; j < len; j++) {
                if (input[j] < minValue) {
                   minValue = input[j];
                   minIndex = j;
                }
            }

            if(input[i] > minValue) {
                int temp = input[i];
                input[i] = input[minIndex];
                input[minIndex] = temp;
            }
        }
        System.out.println(Arrays.toString(input));
    }

    public static void main(String[] args) {
        SelectionSort test = new SelectionSort();
        int[] input = {5, 1, 4, 9, 0, 2};
        test.sort(input);
    }

}
