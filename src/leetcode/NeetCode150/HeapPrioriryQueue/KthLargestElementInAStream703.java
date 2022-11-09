package leetcode.NeetCode150.HeapPrioriryQueue;

import java.util.PriorityQueue;

public class KthLargestElementInAStream703 {
    // Time: O(N * log N + (N - k) * log k)
    // Space: O(N)
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    int kth = 0;
    // N: nums.length, M: number of calls to add()
    // Time: O(N * log N)
    public KthLargestElementInAStream703(int k, int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            minHeap.add(nums[i]); //O(N * log N)
        }

        kth = k;

    }

    public int add(int val) {
        minHeap.add(val);

        while (minHeap.size() > kth) {
            minHeap.poll(); // O((N - k) * log k)
        }

        return minHeap.peek(); // O(1)

    }


}
