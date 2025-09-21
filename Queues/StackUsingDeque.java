// Implement stack using Deque - push-O(n) , pop-O(n) , peek-O(1)
import java.util.*;

public class StackUsingDeque {

    static class Stack {
        Deque<Integer> deque = new LinkedList<>();

        // Push
        public void push(int data) {
            deque.addLast(data);
        }

        // Pop
        public int pop() {
           return deque.removeLast();
        }

        // Peek
        public int peek() {
            return deque.getLast();
        }
    }

    public static void main(String args[]) {
        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);
        System.out.println("Peek = " + s.peek());           // peek = 3
        System.out.println(s.pop());                        // 3
        System.out.println(s.pop());                        // 2
        System.out.println(s.pop());                        // 1
    }
}