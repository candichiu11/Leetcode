package leetcode.NeetCode150.ArraysAndHashing;

import java.util.*;

public class TopKFrequentElements347 {

    // Time: O(n * log k), n: nums.length
    // Space: O(n + k)
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] res = new int[k];

        //O(n)
        for (int i : nums) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> map.get(a) - map.get(b));

        //O(n log k)
        for (int i : map.keySet()) {
            minHeap.add(i);

            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        //O(k)
        for (int i = 0; i < k; i++) {
            res[i] = minHeap.poll();
        }

        return res;
    }

    //Bucket sort
    // Time: O(n)
    // Space: O(n)
    public int[] topKFrequentOptimal(int[] nums, int k) {
        // num, count
        Map<Integer, Integer> map = new HashMap<>();

        //O(n)
        for (int i : nums) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }
        System.out.println(map);

        // Count,  nums
        //O(n)
       Map<Integer, List<Integer>> bucket = new HashMap<>();
       for (int i : map.keySet()) {
           if (!bucket.containsKey(map.get(i))) {
               bucket.put(map.get(i), new ArrayList<>());
           }
           bucket.get(map.get(i)).add(i);
       }

       int[] res = new int[k];
       int l = k - 1;
       for (int i = nums.length; i >= 1; i--) {
           if (bucket.containsKey(i)) {
               for (int j = 0; j < bucket.get(i).size(); j++) {
                   res[l] = bucket.get(i).get(j);
                   l--;
               }
           }
           if (l < 0) break;
       }
        return res;
    }

    public static void main(String[] args) {
        TopKFrequentElements347 test = new TopKFrequentElements347();
        int[] nums = {1,1,1,2,2,3};
        //System.out.println(Arrays.toString(test.topKFrequent(nums, 2)));
        System.out.println(Arrays.toString(test.topKFrequentOptimal(nums, 2)));
    }
}
