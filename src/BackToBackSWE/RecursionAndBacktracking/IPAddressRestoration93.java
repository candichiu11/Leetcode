package BackToBackSWE.RecursionAndBacktracking;

import java.util.ArrayList;
import java.util.List;

public class IPAddressRestoration93 {

    //Time: O(1) , Space: O(1)
    public List<String> restoreIPAddresses(String s) {
        List<String> restoredIP = new ArrayList<>();
        restoreIP(0, 0, new int[4], s, restoredIP);
        return restoredIP;
    }

    private void restoreIP(int progressIndex, int currentSegment,
                           int[] ipAddresses, String s, List<String> restoredIP) {
        //base case
        if(currentSegment == 4 && progressIndex == s.length()) {
            restoredIP.add(constructIPAddresses(ipAddresses));
        } else if(currentSegment == 4) {
            return;
        }

        for(int segLength = 1; segLength <=3 && progressIndex + segLength <= s.length(); segLength++) {
            int onePassSegmentIndex = progressIndex + segLength;
            String segmentAsString = s.substring(progressIndex, onePassSegmentIndex);
            int segmentAsInt = Integer.parseInt(segmentAsString);

            if(segmentAsInt > 255 || (segLength>=2 && segmentAsString.charAt(0) == '0')) {
                break;
            }

            ipAddresses[currentSegment] = segmentAsInt;
            restoreIP(progressIndex + segLength, currentSegment + 1, ipAddresses, s, restoredIP);
        }
    }

    private String constructIPAddresses(int[] ipAddresses) {
        return ipAddresses[0] + "." + ipAddresses[1] + "." + ipAddresses[2] + "." + ipAddresses[3];
    }

}
