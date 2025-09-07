// Delete N Nodes After M nodes of a LL
import java.util.*;

public class PracticeQ {

    public static class Node {
        int data;
        Node next;
    };

    public static Node push(Node head_ref, int new_data) {
        Node newNode = new Node();
        newNode.data = new_data;
        newNode.next = (head_ref);
        (head_ref) = newNode;
        return head_ref;
    }

    public static void printList(Node head) {
        Node temp = head;
        while(temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("Null\n");
    }

    public static void skipMdeleteN(Node head, int M, int N) {
        Node curr = head, t;
        int count;

        while(curr != null) {
            for(count = 1; count < M && curr != null ; count++) 
                curr = curr.next;

                if(curr == null) 
                return;

                t = curr.next;
                for(count = 1 ; count <= N && t != null ; count++) {
                    Node temp = t;
                    t = t.next;
                }
                curr.next = t;
                curr = t;

        }
    }
    

    public static void main(String args[]) {
         PracticeQ list = new PracticeQ();
        Node head = null;
        int M = 3, N = 2;
        head = push(head, 10);
        head = push(head, 9);
        head = push(head, 8);
        head = push(head, 7);
        head = push(head, 6);
        head = push(head, 5);
        head = push(head, 4);
        head = push(head, 3);
        head = push(head, 2);
        head = push(head, 1);

        System.out.println("M = " + M + ", N = " + N);
        printList(head);

        skipMdeleteN(head, M, N);

        System.out.print("\nLinked List on deletion is : \n");
        printList(head);

    }
}