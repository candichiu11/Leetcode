package BackToBackSWE.Sorting;

import java.util.Arrays;

public class CountingInversions {

    //Time: O(n*log n)
    //Space: O(n), we created additional array during merge process.
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
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
                count += (mid + 1) - (l + i);
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
        int[] arr = {870,260,650,208,256,780,54,428,426,284,818,268,748,653,787,61,871,213,265,368,870,82,138,289,170,539,219,134,630,132,433,500,744,83,61,1,863,115,429,641,400,599,261,500,253,48,561,476,614,179,844,484,261,334,125,432,225,345,918,856,477,351,708,222,786,769,575,1,237,4,642,989,956,903,489,561,304,402,389,918,581,585,754,843,919,879,275,497,224,545,705,54,897,413,628,35,535,203,37,124};
        System.out.println(test.countInversions(arr));
    }
}
