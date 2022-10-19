package leetcode.NeetCode150.ArraysAndHashing;

import java.util.ArrayList;
import java.util.List;

public class EncodeAndDecodeStrings271 {

    Character DELIMITER = '#';
    // Time: O(n), n: strs.length
    // Space: O(1), the output is a string
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();

        for (String s : strs) {
            int size = s.length();
            sb.append(size);
            sb.append(DELIMITER);
            sb.append(s);
        }

        return sb.toString();
    }

    // Time: O(n), n: s.length()
    // Space: O(n), the output is an array of strings
    public List<String> decode(String s) {
        List<String> res = new ArrayList<>();
        char[] arr = s.toCharArray();

        int i = 0;
        while (i < arr.length) {
            StringBuilder sb = new StringBuilder();

            while (arr[i] != DELIMITER) {
                sb.append(arr[i]);
                i++;
            }

            int strSize =  Integer.parseInt(sb.toString());
            int idxUpper = i + strSize;
            StringBuilder sb1 = new StringBuilder();

            for (int j = i + 1; j <= idxUpper; j++) {
                sb1.append(arr[j]);
            }

            res.add(sb1.toString());
            i = idxUpper + 1;
        }
        return res;
    }

    public static void main(String[] args) {
        //["63/Rc","h","BmI3FS~J9#vmk","7uBZ?7*/","24h+X","O "]
        EncodeAndDecodeStrings271 test = new EncodeAndDecodeStrings271();
        List<String> strs = new ArrayList<>();
        strs.add("63/Rc");
        strs.add("h");
        strs.add("BmI3FS~J9#vmk");
//        strs.add("7uBZ?7*/");
//        strs.add("24h+X");
//        strs.add("O ");
        System.out.println(test.encode(strs));
        System.out.println(test.decode(test.encode(strs)));
    }
}
