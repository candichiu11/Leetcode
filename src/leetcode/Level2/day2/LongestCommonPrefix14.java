package leetcode.Level2.day2;

import java.util.*;

public class LongestCommonPrefix14 {

    public static void main ( String [ ] args ) {
       LongestCommonPrefix14 l = new LongestCommonPrefix14();
        String[] strs= {"flower","flow","flight"};
       l.longestCommonPrefix(strs);

    }

    //Time: O(nlogn) ,Space: O(1)
    public String longestCommonPrefix(String[] strs) {
        StringBuilder result = new StringBuilder();
        if(strs.length==0) {
            return result.toString();
        }

        Arrays.sort(strs);

        char[] firstStr = strs[0].toCharArray();
        char[] lastStr = strs[strs.length-1].toCharArray();

        for(int i=0; i<firstStr.length; i++) {
            if(firstStr[i] != lastStr[i]){
                break;
            }
            result.append(firstStr[i]);
        }

        if(result.toString().isEmpty()) {
            return "";
        }

        return result.toString();
    }
}

