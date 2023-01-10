package BackToBackSWE.Primitives;

public class ReverseBits190 {

    //Time: O(N), N: size of input in bits
    //Space: O(1), input and a variable output,
    //they both use the same amount of space in memory, so we are using constant space
    public int reverseBits(int n) {
        int result = 0;

        for (int i = 0; i < 32; i++) {
            result = result << 1;

            if ((n & 1) == 1) {
                result = result | (n & 1);
            }

            n = n >> 1;
        }

        return result;

    }
}
