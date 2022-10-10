package BackToBackSWE.DynamicProgramming;

import java.util.*;

public class WordBreak139 {

    //Time: O(n^3)
    //Space: O(n), n: the length of string s
    public boolean workBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        Map<String, Boolean> map = new HashMap<>();
         return helper(s, dict, map);
    }

    private boolean helper(String s, Set<String> dict, Map<String, Boolean> map) {
        //base
        if (s.length() == 0) {
            return true;
        }

        if (map.containsKey(s)) {
            return map.get(s);
        }

        int n = s.length();
        //O(n)
        for (int i = 1; i <= n; i++) {
            String left = s.substring(0, i); //O(n)
            String right = s.substring(i, n);

            if (dict.contains(left) && helper(right, dict, map)) {
                map.put(s, true);
                return true;
            }
        }
        map.put(s, false);
        return false;
    }
}
