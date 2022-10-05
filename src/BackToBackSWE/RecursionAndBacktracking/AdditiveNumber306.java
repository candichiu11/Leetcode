package BackToBackSWE.RecursionAndBacktracking;

public class AdditiveNumber306 {

    //Time : O(n^4)
    //Space: O(n)
    public boolean isAdditiveNumber(String num) {
        if (num.length() == 0) return false;

        int len = num.length();

        for (int i = 1; i < len; i++) {
            long firstNum = parse(num.substring(0, i));
            if (firstNum == -1) {
                continue;
            }

            for (int j = i + 1; j < len; j++) {
                long secondNum = parse(num.substring(i, j));
                if (secondNum == -1) {
                    continue;
                }

                String thirdNum = num.substring(j);
                if(isValidSequence(firstNum, secondNum, thirdNum)) {
                    return true;
                }
            }
        }
       return false;
    }

    private boolean isValidSequence(long firstNum, long secondNum, String remainingNum) {
        //base
        if (remainingNum.length() == 0) {
            return true;
        }

        for (int i = 1; i < remainingNum.length(); i++) {
            long thirdNum = parse(remainingNum.substring(0, i));
            if (thirdNum == -1) {
                continue;
            }

            boolean addUp = thirdNum - firstNum == secondNum;

            if (addUp && isValidSequence(secondNum, thirdNum, remainingNum.substring(i))) {
                return true;
            }

        }
        return false;
    }

    private long parse(String s) {
        if (!s.equals("0") || s.startsWith("0")) {
            return -1;
        }

        long result = 0;
        try {
            result = Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return -1;
        }

        return result;
    }
}
