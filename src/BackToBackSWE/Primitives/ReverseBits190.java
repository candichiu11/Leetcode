package BackToBackSWE.Primitives;

public class ReverseBits190 {

    //Time: O(n), n: size of input in bits
    //Space: O(1), input and a variable output,
    //they both use the same amount of space in memory, so we are using constant space
    public int reverseBits(int input) {
        int output = 0;

        while (input != 0) {
            output = output << 1;

            if ((input & 1) == 1) {
                output = output | 1;
            }

            input = input >> 1;
        }

        return output;

    }
}
