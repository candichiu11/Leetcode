package BackToBackSWE.Primitives;

public class PowerOfTwo231 {

    //Time: O(1)
    //Space: O(1)
    public boolean powerOfTwo(int n) {
        if (n < 0) return false;

        return (n != 0) && (n & n-1) == 0;
    }
}
