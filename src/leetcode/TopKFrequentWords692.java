package leetcode;

import java.util.*;

public class TopKFrequentWords692 {

    public static void main ( String [ ] args ) {
        String[] words = {"i","love","leetcode","i","love","coding"};
        TopKFrequentWords692 tk = new TopKFrequentWords692();
        tk.topKFrequent(words, 2);
    }

    //Time O(nlogn)
    public List<String> topKFrequent(String[] words, int k) {
        List<String> result = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();

        for(int i=0; i<words.length; i++) {
            if(map.containsKey(words[i])) {
                map.put(words[i], map.get(words[i])+1);
            } else {
                map.put(words[i], 1);
            }
        }

        PriorityQueue<String> pq = new PriorityQueue<String>(new Comparator<String>() {
            @Override
            public int compare(String word1, String word2) {
                if(map.get(word1).equals(map.get(word2))) {
                    return word1.compareTo(word2);
                }
                return map.get(word2) - map.get(word1);
            }
        });

        pq.addAll(map.keySet());

        for (int i = 0; i < k; i++) {
            if (!pq.isEmpty()) {
                result.add(pq.poll());
            }
        }

        return result;

    }

}
