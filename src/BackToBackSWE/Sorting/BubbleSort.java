package BackToBackSWE.Sorting;

import java.util.Arrays;

public class BubbleSort {

    //Time: O(n^2) quadratic
    public void sort(int[] input) {
        int len = input.length;

        for(int i = 0; i < len; i++) {
            for(int j = 1; j < len - i; j++) {
                if(input[j] < input[j-1]) {
                    int temp = input[j];
                    input[j] = input[j-1];
                    input[j-1] = temp;
                }
            }
        }

        System.out.println(Arrays.toString(input));
    }

    public static void main(String[] args) {
        BubbleSort test = new BubbleSort();
        int[] input = {5, 1, 4, 9, 0, 2};
        test.sort(input);
    }
}
