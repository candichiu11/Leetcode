package BackToBackSWE.Primitives;

public class AddStrings415 {

    //Time: O(N), N : Math.max(num1.length(), num2.length())
    //Space: O(N)
    public String addStrings(String num1, String num2) {
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carry = 0;
        StringBuilder result = new StringBuilder();

        while (i >= 0 || j >= 0) {
            int d1 = i >= 0 ? num1.charAt(i) - '0' : 0;
            int d2 = j >= 0 ? num2.charAt(j) - '0' : 0;
            int sum = d1 + d2 + carry;
            result.append(sum % 10);
            carry = sum / 10;
            i--;
            j--;
        }

        //99 + 1 = 100
        if (carry == 1) {
            result.append(1);
        }

        return result.reverse().toString();
    }

    public static void main(String[] args) {
        AddStrings415 test = new AddStrings415();
        System.out.println(test.addStrings("2859", "293"));
    }
}
