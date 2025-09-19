// Stack using 2 Queue - Pop(n)

import java.util.*;

public class StackUsingQ {

    static class Stack {
        static Queue<Integer> q1 = new LinkedList<>();
        static Queue<Integer> q2 = new LinkedList<>();

        public static boolean isEmpty() {
            return q1.isEmpty() && q2.isEmpty();
        }

    // Add - O(1)
        public static void push(int data) {
            if(!q1.isEmpty()) {
                q1.add(data);
            } else {
                q2.add(data);
            }
        }
    // Pop - O(n)
        public static int pop() {
            if(isEmpty()) {
                System.out.println("Stack is Empty!");
                return -1;
            }
            int top = -1;

    // case 1 - elements stored in q1
            if(!q1.isEmpty()) {
                while(!q1.isEmpty()) {
                    top = q1.remove();      // last ele of q1 stored in top & return it
                    if(q1.isEmpty()) {
                        break;
                    }
                    q2.add(top);            // if not last ele then store in q2
                }

            } else {        // case 2 - elements stored in q2
                while(!q2.isEmpty()) {
                    top = q2.remove();
                    if(q2.isEmpty()) {
                        break;
                    }
                    q1.add(top);
                }
            }
            return top;
        }

    // Peek - O(n)
        public static int peek() {
            if(isEmpty()) {
                System.out.println("Stack is Empty!");
                return -1;
            }
            int top = -1;

    // case 1 - elements stored in q1
            if(!q1.isEmpty()) {
                while(!q1.isEmpty()) {
                    top = q1.remove();      // last ele of q1 stored in top & return it
                    q2.add(top);            // if not last ele then store in q2
                }

            } else {                        // case 2 - elements stored in q2
                while(!q2.isEmpty()) {
                    top = q2.remove();
                    q1.add(top);
                }
            }
            return top;
        }
    }

    public static void main(String args[]) {
        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);

        while(!s.isEmpty()) {
            System.out.println(s.peek());
            s.pop();
        }
    }
}