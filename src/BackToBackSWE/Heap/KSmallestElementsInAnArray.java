package BackToBackSWE.Heap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class KSmallestElementsInAnArray {

    //Time: O(n * log k), n: total number of elements
    //Space: O(k)
    public List<Integer> kSmallestElements(int[] elements, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, Comparator.reverseOrder());

        for (int element : elements) {
            maxHeap.add(element);

            if(maxHeap.size() == k + 1) {
                maxHeap.poll();
            }
        }

        List<Integer> kSmallestElements = new ArrayList<>(maxHeap);
        return kSmallestElements;
    }
}
