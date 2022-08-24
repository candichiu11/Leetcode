package BackToBackSWE.String;

public class ZigzagConversion6 {

    //Time: O(n), n = s.length()
    //Space: O(n)
    public String convert(String s, int numRows) {
         //Define StringBuilders
        StringBuilder[] sbs = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            sbs[i] = new StringBuilder();
        }

         //Define Variables
        char[] arr = s.toCharArray();
        int n = arr.length;
        int index = 0;

        //Traverse zig zag
        while (index < n) {
            //Go down
            for (int j = 0; j < numRows && index < n; j++) {
                sbs[j].append(arr[index++]);
            }

            //Go Up before start
            for (int k = numRows - 2; k > 0 && index < n; k--) {
                sbs[k].append(arr[index++]);
            }
        }

        //Combine all stringbuilders into one
        StringBuilder result = sbs[0];
        for (int l = 1; l < numRows; l++) {
            result.append(sbs[l]);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        ZigzagConversion6 test = new ZigzagConversion6();
        String s = "PAYPALISHIRING";
        System.out.println(test.convert(s, 4));
    }
}
