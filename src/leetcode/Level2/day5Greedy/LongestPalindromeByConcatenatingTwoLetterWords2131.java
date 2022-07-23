package leetcode.Level2.day5Greedy;

import java.util.HashMap;
import java.util.Map;

public class LongestPalindromeByConcatenatingTwoLetterWords2131 {

//    Input: words = ["ab","ty","yt","lc","cl","ab"]
//    Output: 8
//    Explanation: One longest palindrome is "ty" + "lc" + "cl" + "yt" = "tylcclyt", of length 8.

    public int longestPalindrome(String[] words) {
        // step 1 : build the hashmap along with their frequency of occurrence
          Map<String, Integer> freqMap = new HashMap<>();
          for(int i=0; i< words.length; i++) {
              freqMap.put(words[i], freqMap.getOrDefault(words[i], 0) + 1);
          }
          System.out.println(freqMap);

          int length = 0;
          for(String str: freqMap.keySet()) {
              String reverseStr = reverse(str);

             if(freqMap.containsKey(reverseStr)) {
                 // checking for strings like aa, bb,cc
                 if (reverseStr.equals(str)) {
                     //even number
                     int strFreq = freqMap.get(str);
                     if (strFreq % 2 == 0) {
                         length = length + strFreq * 2;
                         freqMap.put(str, 0);

                     } else {
                         //odd number
                         strFreq = strFreq - 1;
                         length = length + strFreq * 2;
                         freqMap.put(str, 1);
                     }

                 } else {
                     //checking for normal strings like ab, ab, cd, ef , ba, ba, ba
                     int min = 0;
                     min = Math.min(freqMap.get(str), freqMap.get(reverseStr));
                     length = length + min * 4;
                     freqMap.put(str, 0);
                     freqMap.put(reverseStr, 0);
                 }
             }
          }

          // checking for the last addition in the middle of the sort of aa,bb,cc
          for(String str1 : freqMap.keySet()) {
              if(str1.charAt(0) == str1.charAt(1) && freqMap.get(str1) > 0) {
                  length = length + 2; // adding the remaining aa,bb,cc in the middle of the answer
                  break; // important as only one pair can be added in the middle
              }
          }
          return length;
    }

    private String reverse(String s) {
        String reverseString = "";
        for(int i=s.length() -1; i>=0; i--) {
            reverseString = reverseString + s.charAt(i);
        }
       return reverseString;
    }

    public static void main(String[] args) {
        LongestPalindromeByConcatenatingTwoLetterWords2131 test = new LongestPalindromeByConcatenatingTwoLetterWords2131();
        String[] words = {"lc","cl","gg"};
        test.longestPalindrome(words);
    }
}
