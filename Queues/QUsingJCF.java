// Queue Using Java Collection Framework

import java.util.*;

public class QUsingJCF {

    public static void main(String args[]) {
    //   Queue<Integer> q = new LinkedList<>();       // Queue is interface we can't make obj of it
      Queue<Integer> q = new ArrayDeque<>();
        q.add(1);
        q.add(2);
        q.add(3);

        while(!q.isEmpty()) {
            System.out.println(q.peek());
            q.remove();
        }
    }
}