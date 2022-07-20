package leetcode.Level2.day1;

import java.util.HashSet;

public class HappyNumber202 {

    public static void main ( String [ ] args ) {
          HappyNumber202 happy = new HappyNumber202();
          happy.isHappy(19);
    }

    //Time: O(logN) , Space: O(logN)
    public boolean isHappy(int n) {
        HashSet<Integer> seen = new HashSet<>();

        while(n!=1) {
            int currentNumber = n;
            int sum = 0;

            //O(logN)
            while (currentNumber !=0) {
                sum = sum + (currentNumber%10) * (currentNumber%10);
                currentNumber = currentNumber / 10;
            }

            if(seen.contains(sum)){
                return false;
            }

            seen.add(sum);
            n=sum;
        }
        return true;
    }
}
