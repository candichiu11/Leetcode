package BackToBackSWE.Stack;

import java.util.Arrays;

public class ImplementACircularQueue622 {
    //Time: O(1)

    int[] queue;
    int front = 0, rear = 0, size = 0;

    public ImplementACircularQueue622(int k) {
               queue = new int[k];
               Arrays.fill(queue, -1);
    }

    public boolean enqueue(int value) {
       if (isFull()) {
          return false;
       }

       if (isEmpty()) {
           front = rear = 0;
           queue[front] = value;
           size++;
           return true;
       }

       rear++;
       size++;
       rear = rear % queue.length;
       queue[rear] = value;
       return true;
    }

    public boolean dequeue() {
       if (isEmpty()) {
           return false;
       }
        queue[front] = -1;
        front++;
        size--;
        front = front % queue.length;
        return true;
    }

    public int front() {
      return queue[front];
    }

    public int rear() {
      return queue[rear];
    }

    public boolean isEmpty() {
      return size == 0;
    }

    public boolean isFull() {
      return size == queue.length;
    }
}
