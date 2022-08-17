package BackToBackSWE.Heap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class KLargestElementsInAnImmutableMaxHeap {

    //Time: O(k log k)
    //Space: O(k)
    public List<Integer> kLargestInImmutableHeap(int[] maxheap, int k) {
        List<Integer> kLargestResult = new ArrayList<>();
        int maxCandidateSize = 10;
        PriorityQueue<HeapItem> maxCandidate = new PriorityQueue<>(maxCandidateSize, new TwoHeapItemComparator());
        maxCandidate.add(new HeapItem(0, maxheap[0]));

        for (int i = 0; i < k; i++) { //k iteration O(k)
            HeapItem candidate = maxCandidate.poll(); // removal: O(log k)
            kLargestResult.add(candidate.value);

            int leftChildIndex = candidate.getLeftChildIndex();
            if (leftChildIndex < maxheap.length) {
                maxCandidate.add(new HeapItem(leftChildIndex, maxheap[leftChildIndex]));
            }

            int rightChildIndex = candidate.getRightChildIndex();
            if (rightChildIndex < maxheap.length) {
                maxCandidate.add(new HeapItem(rightChildIndex, maxheap[rightChildIndex]));
            }

        }
        return kLargestResult;
    }

    class TwoHeapItemComparator implements Comparator<HeapItem> {
        public int compare(HeapItem a, HeapItem b) {
            return Integer.compare(b.value, a.value);
        }
    }

    class HeapItem {
        int index;
        int value;

        public HeapItem(int index, int value) {
            this.index = index;
            this.value = value;
        }

        public int getLeftChildIndex() {
            return 2*index + 1;
        }

        public int getRightChildIndex() {
            return 2*index + 2;
        }

        public int getParentIndex() {
            return (index - 1) / 2;
        }
    }

}
