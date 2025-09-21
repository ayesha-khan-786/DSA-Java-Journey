// Implement Deque(Double Ended Queue) using JCF
import java.util.*;

public class DequeDEQ {

    public static void main(String args[]) {
        Deque<Integer> deque = new LinkedList<>();
        deque.addFirst(1);          // o/p - 1
        deque.addFirst(2);          // 2 1
        deque.addLast(3);           // 2 1 3
        deque.addLast(4);           // 2 1 3 4
        System.out.println(deque);

        deque.removeFirst();        // 1 3 4
        System.out.println(deque);

        deque.removeLast();         // 1 3
        System.out.println(deque);

        System.out.println("First element = " + deque.getFirst());      // 1
        System.out.println("Last element = " + deque.getLast());        // 3
    }
}