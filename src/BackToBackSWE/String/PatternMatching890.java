package BackToBackSWE.String;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PatternMatching890 {

    private String buildMapping(String str) {
        Map<Character, Integer> map = new HashMap<>();
        int i = 0;
        String result = "";

        for (int j = 0; j < str.length(); j++) {
            if(!map.containsKey(str.charAt(j))){
                map.put(str.charAt(j), i++);
            }
            result += map.get(str.charAt(j));
        }

        return result;
    }

    //Time: O(n * k), n: number of words, k: length of each word
    //Space: O(n * k), the space used by creating HashMap
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> mappingWords = new ArrayList<>();
        String patternMapping = buildMapping(pattern);

        for (String word : words) {
            String wordMapping = buildMapping(word);

            if (word.length() == pattern.length() &&
                    wordMapping.equals(patternMapping)) {
                mappingWords.add(word);
            }
        }

        return mappingWords;
    }
}
