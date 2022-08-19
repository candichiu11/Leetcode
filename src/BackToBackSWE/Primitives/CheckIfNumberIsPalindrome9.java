package BackToBackSWE.Primitives;

public class CheckIfNumberIsPalindrome9 {

    //Time: O(n), Linear
    //Space: O(1)
    public boolean isPalindrone(int x) {
        if (x < 0) return false;

        double log10Value = Math.log10(x);
        int totalDigit = (int) (Math.floor(log10Value) + 1);
        int mask = (int) Math.pow(10, totalDigit - 1);

        for (int i = 0; i < totalDigit/2; i++) {
            int firstDigit = x / mask;
            int lastDigit = x % 10;

            if (firstDigit != lastDigit) {
                return false;
            }

            x %= mask;
            x /= 10;

            mask /= 100;
        }

        return true;
    }
}
