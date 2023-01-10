package leetcode.NeetCode150.Greedy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class HandOfStraights846 {

    // Time: O(N*log N + N*groupSize)
    // Space: O(N)
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        if (n % groupSize != 0) return false;

        Map<Integer, Integer> map = new HashMap<>();
        for (int card : hand) {
            if (map.containsKey(card)) {
                map.put(card, map.get(card) + 1);
            } else {
                map.put(card, 1);
            }
        }

        Arrays.sort(hand);
        for (int card : hand) {
            if (map.get(card) == 0) continue;

            for (int i = 1; i < groupSize; i++) {
                if (map.containsKey(card + i) && map.get(card + i) > 0) {
                    map.put(card + i, map.get(card + i) - 1);
                } else {
                    return false;
                }
            }
            map.put(card, map.get(card) - 1);
        }
        return true;
    }
}
