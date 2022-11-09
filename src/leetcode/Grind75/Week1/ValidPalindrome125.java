package leetcode.Grind75.Week1;

import java.util.ArrayList;
import java.util.List;

public class ValidPalindrome125 {

    //Time: O(n)
    //Space: O(1)
    public boolean isPalindrome(String s) {
        if (s.length() == 0) return true;

        StringBuilder sb = new StringBuilder();

        //O(n)
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c) || Character.isLetter(c)) {
                sb.append(c);
            }
        }

        String str = sb.toString().toLowerCase();

        int l = 0;
        int r = str.length() - 1;

        //O(n)
        while (l < r) {
            if (str.charAt(l) != str.charAt(r)) {
                return false;
            } else {
                l++;
                r--;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        ValidPalindrome125 test = new ValidPalindrome125();
        System.out.println(test.isPalindrome("A man, a plan, a canal: Panama"));
    }

}
