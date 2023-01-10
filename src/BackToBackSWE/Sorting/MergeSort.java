package BackToBackSWE.Sorting;

import java.util.Arrays;

public class MergeSort {

    // Time: O(n log n)
    public void mergeSort(int[] inputArray) {
        int inputLen = inputArray.length;

        if (inputLen < 2) return;

        int leftLen = inputLen / 2;
        int[] leftHalf = new int[leftLen];

        int rightLen = inputLen - leftLen;
        int[] rightHalf = new int[rightLen];

        for (int i = 0; i < leftLen; i++) {
            leftHalf[i] = inputArray[i];
        }

        for (int i = leftLen; i < inputLen; i++) {
            rightHalf[i - leftLen] = inputArray[i];
        }

        mergeSort(leftHalf);
        mergeSort(rightHalf);

        merge(inputArray, leftHalf, rightHalf);
    }

    private void merge(int[] inputArray, int[] leftHalf, int[] rightHalf) {
        int leftLen = leftHalf.length;
        int rightLen = rightHalf.length;
        int i = 0, j = 0, k = 0;

        while (i < leftLen && j < rightLen) {
            if (leftHalf[i] <= rightHalf[j]) {
                inputArray[k] = leftHalf[i];
                i++;
            } else {
                inputArray[k] = rightHalf[j];
                j++;
            }
            k++;
        }

        while (i < leftLen) {
            inputArray[k] = leftHalf[i];
            i++;
            k++;
        }

        while (j < rightLen) {
            inputArray[k] = rightHalf[j];
            j++;
            k++;
        }

    }

    public static void main(String[] args) {
        MergeSort test = new MergeSort();
        int[] inputArray = {10, 5, 7, 4, 0, 35, 8, 100, 1};
        test.mergeSort(inputArray);
        System.out.println(Arrays.toString(inputArray));
    }
}
