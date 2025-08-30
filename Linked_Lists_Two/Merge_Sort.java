public class LinkedList {

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


    // Methods to add last
    public void addLast(int data) {
        Node newNode = new Node(data);
        if(head == null) {
            head = tail =newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;

    }

     // Print Linked List
    public void print() {
        if(head == null) {
            System.out.println("Linked List is empty.");
            return;
        }
        Node temp = head;
        while(temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }


    private Node getMid(Node head) {
        Node slow = head;
        Node fast = head.next;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;                // mid node
    }

    private Node merge(Node head1, Node head2) {
        Node mergedLL = new Node(-1);
        Node temp = mergedLL;

        while(head1 != null && head2 != null) {         // head1 -> left , head2 -> right half
            if(head1.data <= head2.data) {
                temp.next = head1;
                head1 = head1.next;
                temp = temp.next;
            } else {
                temp.next = head2;
                head2 = head2.next;
                temp = temp.next;
            }
        }
        // for remaining elements
        while(head1 != null) {
            temp.next = head1;
            head1 = head1.next;
            temp = temp.next;
        }
        while(head2 != null) {
            temp.next = head2;
            head2 = head2.next;
            temp = temp.next;
        }

        return mergedLL.next;
    }

    // Merge Sort
    public Node mergeSort(Node head) {
        // Base Case
        if(head == null || head.next == null) {         // already sorted
            return head;        
        }

        // Find mid
        Node mid = getMid(head);

        // Divide -> left half & right half
        Node rightHead = mid.next;
        mid.next = null;
        Node newLeft = mergeSort(head);           // left half
        Node newRight = mergeSort(rightHead);       // right half

        // Merge
        return merge(newLeft, newRight);
    }

    public static void main(String args[]) {
        LinkedList ll = new LinkedList();
        ll.addLast(5);
        ll.addLast(4);
        ll.addLast(3);
        ll.addLast(2);
        ll.addLast(1);
       // 5 -> 4 -> 3 -> 2 -> 1
       ll.print();
       ll.head = ll.mergeSort(ll.head);
       ll.print();
    }
}

// Time Complexity = O(nlogn) 