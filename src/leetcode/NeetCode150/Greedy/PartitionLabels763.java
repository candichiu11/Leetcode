package leetcode.NeetCode150.Greedy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PartitionLabels763 {

    // Time: O(N)
    // Space: O(1)
    public List<Integer> partitionLabels(String s) {
         int n = s.length();
         Map<Character, Integer> map = new HashMap<>();
         List<Integer> res = new ArrayList<>();

         for (int i = 0; i < n; i++) {
             map.put(s.charAt(i), i);
         }

         int size = 0;
         int end = 0;
         for (int i = 0; i < n; i++) {
             size++;
             end = Math.max(end, map.get(s.charAt(i)));
             if (end == i) {
                 res.add(size);
                 size = 0;
             }
         }

         return res;
    }

    public static void main(String[] args) {
        PartitionLabels763 test = new PartitionLabels763();
        test.partitionLabels("ababcbacadefegdehijhklij");
    }
}
