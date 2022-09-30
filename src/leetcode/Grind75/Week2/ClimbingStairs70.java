package leetcode.Grind75.Week2;

public class ClimbingStairs70 {

    //Time: O(n)
    //Space: O(n)
    public int climbChairs(int n) {
        int[] fib = new int[n + 1];
        if (n == 1) return 1;

        fib[1] = 1;
        fib[2] = 2;

        for (int i = 3; i < n + 1; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }

        return fib[n];
    }
}
