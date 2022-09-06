package BackToBackSWE.String;

public class AddBinaryStrings67 {

    //Time: O(N), N: Math.max(a.length(), b.length())
    //Space: O(N) size of the result object
    public String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;

        while (i >= 0 || j >= 0) {
            int d1 = i >= 0 ? a.charAt(i) - '0' : 0;
            int d2 = j >= 0 ? b.charAt(j) - '0' : 0;
            int sum = d1 + d2 + carry;

            result.append(sum % 2);
            carry = sum / 2;
            i--;
            j--;
        }

        if (carry == 1) {
            result.append(1);
        }

        return result.reverse().toString();
    }

    public static void main(String[] args) {
        AddBinaryStrings67 test = new AddBinaryStrings67();
        System.out.println(test.addBinary("1010", "1011"));
    }
}
