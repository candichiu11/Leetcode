package leetcode.Grind75.Week1;

import java.util.ArrayList;
import java.util.List;

public class ValidPalindrome125 {

    //Time: O(n) , n: the length of string s
    //Space: O(n)
    public boolean isPalindrome(String s) {
        List<Character> list = new ArrayList<>();

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c) || Character.isLetter(c)) {
                list.add(Character.toLowerCase(c));
            }
        }

        char[] clean = new char[list.size()];

        for (int j = 0; j < clean.length; j++) {
            clean[j] = list.get(j);
        }

        for (int i = 0; i < clean.length; i++) {
            if (clean[i] != clean[clean.length - 1 - i]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        ValidPalindrome125 test = new ValidPalindrome125();
        System.out.println(test.isPalindrome("A man, a plan, a canal: Panama"));
    }

}
