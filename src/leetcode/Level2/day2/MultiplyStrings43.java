package leetcode.Level2.day2;

public class MultiplyStrings43 {

    public static void main ( String [ ] args ) {
       MultiplyStrings43 m = new MultiplyStrings43();
       m.multiply("123", "456"); //56088
    }

    //Time: O(m*n), Space: O(m+n);
    public String multiply(String num1, String num2) {
        int n1Len = num1.length();
        int n2Len = num2.length();
        int[] result = new int[n1Len + n2Len];

        for(int j=n2Len-1; j>=0; j--){
            for(int i=n1Len-1; i>=0; i--) {
                int product = (num2.charAt(j)-'0') * (num1.charAt(i)-'0');
                int temp = product + result[i+j+1];

                result[i+j+1] = temp % 10;
                result[i+j] = result[i+j] + temp/10;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int r: result) {
            if(r==0 && sb.length()==0) {
                continue;
            }
            sb.append(r);
        }

       return sb.length()==0 ? "0" : sb.toString();
    }
}
