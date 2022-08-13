package BackToBackSWE.Sorting;

import java.util.PriorityQueue;

public class SortKSortedArray {

    //Time: O(n log k), n: the number of items in the array.
    //Space: O(k), k+1 items in minHeap
    public int[] sortNearlySortedArray(int[] arr, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int len = arr.length;

        for(int i = 0; i < k; i++) {
            minHeap.add(arr[i]);
        }

        int pushIndex = k;
        int placeIndex = 0;

        while (pushIndex < len) {
            minHeap.add(arr[k]);
            k++;
            arr[placeIndex] = minHeap.poll();
            placeIndex++;
        }

        while(!minHeap.isEmpty()) {
            arr[placeIndex] = minHeap.poll();
            placeIndex++;
        }

        return arr;
    }
}
