package BackToBackSWE.Heap;

public class KSmallestElementInAnArrayQuickSelection {
    // Quickselect is a selection algorithm to find the k-th smallest
    // element in an unordered list.
    //Time: O(n) n: nums.length, O(n^2) worst case, if nums is already a sorted array
    //Space: O(1)
    public int kthSmallestElement(int[] nums, int k) {
       int low = 0;
       int high = nums.length - 1;

       while (low < high) {
           int pivotPoint = getPivotPoint(nums, low, high);
           if (pivotPoint == k -1) {
               return nums[pivotPoint];
           } else if (pivotPoint < k - 1) {
               low = pivotPoint + 1;
           } else {
               high = pivotPoint - 1;
           }
       }
        return nums[k - 1];

    }

    private int getPivotPoint(int[] arr, int low, int high) {
        int pivotElement = arr[high];
        int pivotPoint = low;

        for (int i = low; i<=high; i++) {
            if (arr[i] < pivotElement) {
                swap(arr, i, pivotPoint);
                pivotPoint++;
            }
        }

        swap(arr, pivotPoint, high);

        return pivotPoint;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

    }

    public static void main(String[] args) {
        KSmallestElementInAnArrayQuickSelection test = new KSmallestElementInAnArrayQuickSelection();
        int[] nums = {4, 5, 10, 11, 1, 3, 19, 8, 7};
        System.out.println(test.kthSmallestElement(nums, 5));
    }
}
