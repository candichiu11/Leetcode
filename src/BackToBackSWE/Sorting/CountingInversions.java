package BackToBackSWE.Sorting;

import java.util.Arrays;

public class CountingInversions {

    public int countInversions(int[] arr) {
        return mergeSortAndCount(arr, 0, arr.length - 1);
    }

    private int mergeSortAndCount(int[] arr, int l, int r) {
        int count = 0;
        int mid = l + (r -l) / 2;

        if (l < r) {
            count += mergeSortAndCount(arr, l, mid);
            count += mergeSortAndCount(arr, mid + 1, r);
            count += mergeAndCount(arr, l, r, mid);
        }

        return count;
    }

    private int mergeAndCount(int[] arr, int l, int r, int mid) {
        int[] left = Arrays.copyOfRange(arr, l, mid + 1);
        int[] right = Arrays.copyOfRange(arr, mid + 1, r + 1);

        int i = 0, j = 0, k = l, count = 0;

        while (i < left.length && j < right.length) {
            if (left[i] < right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
                count += mid + 1 - i;
            }
        }

        while (i < left.length) {
            arr[k++] = left[i++];
        }

        while (j < right.length) {
            arr[k++] = right[j++];
        }
        System.out.println(Arrays.toString(arr));
        return count;
    }

    public static void main(String[] args) {
        CountingInversions test = new CountingInversions();
        int[] arr = {1, 20, 6, 4, 5};
        System.out.println(test.countInversions(arr));
    }
}
