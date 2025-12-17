//Question 5 : Merge K Sorted Linked List
import java.util.*;

public class Q1 {

    static class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

    static Node mergeList(Node a[], int k) {
        // custom comparator for min Heap
         PriorityQueue<Node> pq = new PriorityQueue<>(
            (x, y) -> Integer.compare(x.data, y.data)
         );

        // Add the head of each non-null list to pq
        for(int i=0 ; i<k ; i++) {
            if(a[i] != null) {
                pq.add(a[i]);
            }
        }

        Node head = null;
        Node temp = null;

        // Merge list
        while(!pq.isEmpty()) {
            Node curr = pq.poll();      // poll -> top element -> initialize and remove

            if(head == null) {
                head = curr;
                temp = curr;
            } else {
                temp.next = curr;
                temp = curr;
            }

            if(curr.next != null) {
                pq.add(curr.next);
            }
        }
        
        return head;
    }

    public static void printList(Node node){
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }

    public static void main(String args[]) {
        int N = 3;
        Node[] a = new Node[N];

        Node head1 = new Node(1);
        a[0] = head1;
        head1.next = new Node(3);
        head1.next.next = new Node(5);
        head1.next.next.next = new Node(7);
     
        Node head2 = new Node(2);
        a[1] = head2;
        head2.next = new Node(4);
        head2.next.next = new Node(6);
        head2.next.next.next = new Node(8);
        
        Node head3 = new Node(0);
        a[2] = head3;
        head3.next = new Node(9);
        head3.next.next = new Node(10);
        head3.next.next.next = new Node(11);

        Node res = mergeList(a, N);
        if (res != null)
            printList(res);
            System.out.println();
    }
}

// Output -> 0 1 2 3 4 5 6 7 8 9 10 11 
// TC = O(nlogk)