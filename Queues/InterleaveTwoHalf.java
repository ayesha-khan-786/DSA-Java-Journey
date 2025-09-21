// Interleave 2 halves of a Queue
import java.util.*;

public class InterleaveTwoHalf {

    public static void interLeave(Queue<Integer> q) {

        Queue<Integer> firstHalf = new LinkedList<>();
        int size = q.size();

         // Step 1 - store 1st half from q in firstHalf       
        for(int i=0 ; i<size/2 ; i++) {
            firstHalf.add(q.remove());      // remove from q n add in firstHalf
        }

        while(!firstHalf.isEmpty()) {
            q.add(firstHalf.remove());         // remove from firstHalf add in q
            q.add(q.remove());                 // remove from q(front) add in q(rear)  
        }
    }

    public static void main(String args[]) {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);
        q.add(7);
        q.add(8);
        q.add(9);
        q.add(10);

        interLeave(q);

        // Print Q
        while(!q.isEmpty()) {
            System.out.print(q.remove() + " ");
        }
        System.out.println();
    }
}