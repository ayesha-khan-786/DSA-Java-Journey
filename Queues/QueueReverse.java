// Queue Reversal - O(n)

import java.util.*;

public class QueueReverse {

    public static void reverse(Queue<Integer> q) {
        Stack<Integer> s = new Stack<>();

    // Step 1 - Remove from q and add in stack
        while(!q.isEmpty()) {
            s.push(q.remove());
        }

    // step 1 - pop from stack and add in q
        while(!s.isEmpty()) {
            q.add(s.pop());
        }
    }

    public static void main(String args[]) {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);

        reverse(q);

    // Print Q
    while(!q.isEmpty()) {
        System.out.print(q.remove() + " ");
      }

      System.out.println();
    }
}