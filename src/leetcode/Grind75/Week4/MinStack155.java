package leetcode.Grind75.Week4;

import java.util.Stack;

public class MinStack155 {

    Stack<Integer> stack = new Stack<>();
    Stack<Integer> cacheMin = new Stack<>();

    // Space: O(n), Worst case is that all the operations are push.
    // In this case, there will be O(2 * n) = O(n)O(2⋅n)=O(n) space used.
    public MinStack155() {

    }

    //O(1)
    public void push(int val) {
       stack.push(val);

       if (cacheMin.isEmpty() || cacheMin.peek() > val) {
           cacheMin.push(val);
       } else {
           cacheMin.push(cacheMin.peek());
       }

    }

    //O(1)
    public void pop() {
         stack.pop();
         cacheMin.pop();
    }

    //O(1)
    public int top() {
         return stack.peek();
    }

    //O(1)
    public int getMin() {
        return cacheMin.peek();
    }
}
