package BackToBackSWE.RecursionAndBacktracking;

import java.util.*;

public class phoneNumberMnemonics17 {

//    private List<String> digitToPossibleLetters = Arrays.asList(
//            "",     //0
//            "",     //1
//            "abc",  //2
//            "def",  //3
//            "ghi",  //4
//            "jkl",  //5
//            "mno",  //6
//            "pqrs", //7
//            "tuv",  //8
//            "wxyz"  //9
//    );
//
//    //Time: O(4^n) n: the length of digits
//    //Space: O(n), the recursion only go as deep as the number of digits in the input,
//    // whenever we reach the depth, we backtrack
//    public List<String> letterCombinations (String digits) {
//           if(digits.length() == 0) return new ArrayList<>();
//
//           List<String> result = new ArrayList<>();
//           exploreCombination(0, new StringBuilder(), digits, result);
//           return result;
//    }
//
//    private void exploreCombination(int currentDigit, StringBuilder partialAnswer, String digits, List<String> result) {
//        //base case
//        if(currentDigit == digits.length()) {
//            result.add(partialAnswer.toString());
//            return;
//        }
//
//        char digitCharacter = digits.charAt(currentDigit);
//        int digitAsInt = digitCharacter - '0';
//        String letters = digitToPossibleLetters.get(digitAsInt);
//
//        for(char c: letters.toCharArray()) {
//            partialAnswer.append(c);
//            exploreCombination(currentDigit+1, partialAnswer, digits, result);
//            partialAnswer.deleteCharAt(partialAnswer.length()-1);
//        }
//
//    }

    private Map<Character, String> map = new HashMap<>() {{
        put('2', "abc");
        put('3', "def");
        put('4', "ghi");
        put('5', "jkl");
        put('6', "mno");
        put('7', "pqrs");
        put('8', "tuv");
        put('9', "wxyz");
    }};

    // Time: O(4^n), n: digits.length()
    // Space: O(n)
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits.length() == 0) return res;
        backtrack(0, digits, new StringBuilder(), res);

        return res;
    }

    private void backtrack(int index, String digits, StringBuilder sb, List<String> res) {
        //base
        if (index == digits.length()) {
            res.add(sb.toString());
            return;
        }

        char digit = digits.charAt(index);
        String letters = map.get(digit);

        for (char l : letters.toCharArray()) {
            sb.append(l);
            backtrack(index + 1, digits, sb, res);
            sb.deleteCharAt(sb.length() - 1);
        }

    }
}
