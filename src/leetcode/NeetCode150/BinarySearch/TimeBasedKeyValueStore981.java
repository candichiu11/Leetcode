package leetcode.NeetCode150.BinarySearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TimeBasedKeyValueStore981 {

    Map<String, List<Data>> map = new HashMap<>();

    public TimeBasedKeyValueStore981() {

    }

    //Time: O(1)
    //Space: O(N) N: number of key: value stored
    public void set(String key, String value, int timestamp) {
         if (!map.containsKey(key)) {
             map.put(key, new ArrayList<>());
         }
         map.get(key).add(new Data(value, timestamp));
    }

    //Time: O(log n), n: dataList.size()
    //Space: O(1)
    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) return "";

        List<Data> dataList = map.get(key);

        int l = 0, r = dataList.size() - 1;
        int m = 0;
        String ans = "";

        while (l <= r) {
            m = (l + r)/2;
            int curr = dataList.get(m).timeStamp;

            if (curr == timestamp) {
                ans = dataList.get(m).value;
            }

            if (curr > timestamp) {
                r = m - 1;
            } else {
                ans = dataList.get(m).value;
                l = m + 1;
            }
        }

        return ans;
    }


    class Data {
        String value;
        int timeStamp;
        public Data(String value, int timeStamp) {
            this.value = value;
            this.timeStamp = timeStamp;
        }

    }
}
