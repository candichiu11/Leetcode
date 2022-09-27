package leetcode.Grind75.Week1;

import java.util.Stack;

public class ImplementQueueUsingStacks232 {

   Stack<Integer> pushStack = new Stack<>();
   Stack<Integer> popStack = new Stack<>();

   public ImplementQueueUsingStacks232() {

   }

   //Time: O(1)
   //Space: O(n), We need additional memory to store the queue elements
   public void push(int x) {
       pushStack.add(x);
   }

   //Time: O(n)
   //Space: O(1)
   public int pop() {
      peek();
      return popStack.pop();
   }

    //Time: O(n)
    //Space: O(1)
   public int peek() {
      convertPushToPop();
      return popStack.peek();
   }

   //Time: O(1)
   //Space: O(1)
   public boolean empty() {
       return pushStack.isEmpty() && popStack.isEmpty();
   }

   //Time: O(2n) = O(n)
   private void convertPushToPop() {
       if (popStack.isEmpty()) {
           while (!pushStack.isEmpty()) {
               popStack.add(pushStack.pop());
           }
       }
   }
}
