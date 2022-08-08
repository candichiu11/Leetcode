package BackToBackSWE.RecursionAndBacktracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class phoneNumberMnemonics17 {

    private List<String> digitToPossibleLetters = Arrays.asList(
            "",     //0
            "",     //1
            "abc",  //2
            "def",  //3
            "ghi",  //4
            "jkl",  //5
            "mno",  //6
            "pqrs", //7
            "tuv",  //8
            "wxyz"  //9
    );

    //Time: O(4^n) n: the length of digits
    //Space: O(n), the recursion only go as deep as the number of digits in the input,
    // whenever we reach the depth, we backtrack
    public List<String> letterCombinations (String digits) {
           if(digits.length() == 0) return new ArrayList<>();

           List<String> result = new ArrayList<>();
           exploreCombination(0, new StringBuilder(), digits, result);
           return result;
    }

    private void exploreCombination(int currentDigit, StringBuilder partialAnswer, String digits, List<String> result) {
        //base case
        if(currentDigit == digits.length()) {
            result.add(partialAnswer.toString());
            return;
        }

        char digitCharacter = digits.charAt(currentDigit);
        int digitAsInt = digitCharacter - '0';
        String letters = digitToPossibleLetters.get(digitAsInt);

        for(char c: letters.toCharArray()) {
            partialAnswer.append(c);
            exploreCombination(currentDigit+1, partialAnswer, digits, result);
            partialAnswer.deleteCharAt(partialAnswer.length()-1);
        }

    }
}
