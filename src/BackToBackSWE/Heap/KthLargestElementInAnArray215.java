package BackToBackSWE.Heap;

import java.util.PriorityQueue;

public class KthLargestElementInAnArray215 {

    //Time: O(n * log k), n : nums.length , k : minHeap.size()
    //Space: O(k)
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int element : nums) {
            minHeap.add(element);

            if (minHeap.size() == k + 1) {
                minHeap.poll();
            }
        }

        return minHeap.peek();
    }

    public static void main(String[] args) {
        KthLargestElementInAnArray215 test = new KthLargestElementInAnArray215();
        int[] nums = {3,2,1,5,6,4};
        System.out.println(test.findKthLargest(nums, 2));
    }
}
