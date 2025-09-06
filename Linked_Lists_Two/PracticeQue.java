// #LeetCode = 160 -  Intersection of Two Linked Lists

public class PracticeQue {
    
     public static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
     }

     public static Node getIntersectionNode(Node head1, Node head2) {
        Node curr1 = head1;
        Node curr2 = head2;

        while(curr1 != curr2) {
            curr1 = curr1.next;
            curr2 = curr2.next;

            if(curr1 == null && curr2 == null) {
                return null;
            }

            if(curr1 == null) {
                curr1 = head2;
            }

            if(curr2 == null) {
                curr2 = head1;
            }
        }
        return curr1;
     }


public static void main(String args[]) {
    PracticeQue list = new PracticeQue();

    Node head1, head2;
    head1 = new Node(10);
    head2 = new Node(3);

    Node newNode = new Node(6);
    head2.next = newNode;

    newNode = new Node(9);
    head2.next.next = newNode;

    newNode = new Node(15);
    head1.next = newNode;
    head2.next.next.next = newNode;

    newNode = new Node(30);
    head1.next.next = newNode;

    head1.next.next.next = null;

    Node intersectionPoint = list.getIntersectionNode(head1, head2);

    if(intersectionPoint == null) {
        System.out.print("No intersection Point \n");
    } else {
         System.out.print("intersection Point :" + intersectionPoint.data);
    }
}
}

// Time Complexity - O(n)  | Space COmplexity - O(1)