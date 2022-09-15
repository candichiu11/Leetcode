package BackToBackSWE.Array;

import java.util.ArrayList;
import java.util.List;

public class EnumerateAllPrimesToN204 {

    /*Time: O(n * log(log(n))
    For 2, we have to cross out n/2 numbers.
    For 3, we have to cross out n/3 numbers.
    For 5, we have to cross out n/5 numbers.
    ...etc for each prime less than n.

    O(n/2 + n/3 + n/5 + ... + n/(last prime before n))
    = O(n) * O(1/2 + 1/3 + 1/5 + ... + 1/(last prime before n))
    What can O(1/2 + 1/3 + 1/5 + ... + 1/(last prime before n)) be simplified to in terms of n?
    I won't go into detail here but the answer is essentially bounded by log(log(n)).

    So now we have that the time complexity of "crossing out" is:
    O(n) * O(1/2 + 1/3 + 1/5 + ... + 1/(last prime before n))
  = O(n) * O(log(log(n)))
  = O(nlog(log(n)))
    */

    //Space: O(n)
    public List<Integer> enumeratePrimes(int n) {
        List<Integer> result = new ArrayList<>();
        if (n < 2) return result;

        boolean[] composite = new boolean[n];
        composite[0] = true;
        composite[1] = true;

        int limit = (int) Math.sqrt(n);
        for (int i = 2; i <= limit; i++) {
            if (composite[i] == false) {

                for (int j = 2; i * j < n; j++) {
                    composite[i * j] = true;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (!composite[i]) {
                result.add(i);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        EnumerateAllPrimesToN204 test = new EnumerateAllPrimesToN204();
        System.out.println(test.enumeratePrimes(30));
    }
}
