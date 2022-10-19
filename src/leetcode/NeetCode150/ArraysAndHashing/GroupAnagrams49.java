package leetcode.NeetCode150.ArraysAndHashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams49 {

    // Time: O(n * k) n: strs.length, k = s.length
    // Space: O(n)
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        if (strs.length == 0) return result;
        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            String key = generateKey(s);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(s);
        }

        return new ArrayList<>(map.values());
    }

    private String generateKey(String s) {
        int[] count = new int[26];
        char[] arr = s.toCharArray();

        for (char c : arr) {
            count[c - 'a']++;
        }

        StringBuilder sb = new StringBuilder();

        for (int i : count) {
            sb.append(i);
            sb.append("#");
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        GroupAnagrams49 test = new GroupAnagrams49();
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        System.out.println(test.groupAnagrams(strs));
        System.out.println(test.generateKey("eat"));
    }
}
