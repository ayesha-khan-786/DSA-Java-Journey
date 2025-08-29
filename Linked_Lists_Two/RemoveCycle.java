import java.util.*;

public class RemoveCycle {
    
    public static class Node {
        int data;
        Node next;

         // constructor
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;

    public void addFirst(int data) {
        Node newNode = new Node(data);
        if(head == null) {
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    public void print() {
        if(head == null) {
            System.out.println("Linked List is empty!");
            return;
        }
        Node temp = head;
        while(temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("Null");
    }

    // Floyd's Cycle Finding Algorithm

    public static boolean isCycle() {
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;           // Slow + 1
            fast = fast.next.next;      // fast + 2

            if(slow == fast) {
                return true;             // cycle exists
            }
        }

        return false;                   // cycle does not exists
    }

    public static void removeCycle() {
        // detect cycle
        Node slow = head;
        Node fast = head;
        boolean cycle = false;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        if(fast == slow) {
            cycle = true;
            break;
        }
    }
    if(cycle == false) {        // cycle does't exists
        return;     
    }

        //find meeting point
        slow = head;
        Node prev = null;       // after while loop last node vl store in prev
        while(slow != fast) {
            prev = fast;
            slow = slow.next;
            fast = fast.next;
        }

        // remove cycle -> last.next = null
        prev.next = null;
    }

    public static void main(String args[]) {
        head = new Node(1);
        Node temp = new Node(2);
        head.next = temp;
        head.next.next = new Node(3);
        head.next.next.next = temp;
        // 1 -> 2 -> 3 -> 2

        System.out.println(isCycle());
        removeCycle();
        System.out.println(isCycle());
    }
}