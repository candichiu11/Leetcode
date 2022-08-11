package BackToBackSWE.Sorting;

public class VerifyingCharacterOrdering953 {

    //Time: O(M), M: the total number of characters in words array
    //Space: O(1)
    public boolean verifyOrder(String[] words, String order) {
        int[] mapping = new int[26];
        int seq = 0;

        for (char c: order.toCharArray()) {
            mapping[c - 'a'] = seq++;
        }

        for (int i = 0; i < words.length - 1; i++) {
            String curr = words[i];
            String next = words[i+1];

            int minLength = Math.min(curr.length(), next.length());

            //for case: ["apple", "app"]
            if (minLength != curr.length() && minLength == next.length() && curr.startsWith(next)) return false;

            for (int j = 0; j < minLength; j++) {

                if (mapping[curr.charAt(j) - 'a'] > mapping[next.charAt(j) - 'a']){
                    return false;
                } else if (mapping[curr.charAt(j) - 'a'] < mapping[next.charAt(j) - 'a']) {
                    break;
                }
            }
        }
          return true;
    }
}
