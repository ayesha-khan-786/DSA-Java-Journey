public class LinkedList {

    public static class Node {
        int data;
        Node next;          // reference to point next node

        // constructor
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    public static Node head;
    public static Node tail;

    // Methods to add LL
    public void addFirst(int data) {
         // Step-1 create new node
        Node newNode = new Node(data);

        // if LL is empty
        if(head == null) {
            head = tail = newNode;
            return;
        }
        
        // if LL is not empty follow step 2 & 3
        // Step-2 newNode next = head
        newNode.next = head;        // link

        // Step-3 head = newNode
        head = newNode;
    }

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

    public static void main(String args[]) {
        LinkedList ll = new LinkedList();
        ll.print();
        ll.addFirst(2);
        ll.print();
        ll.addFirst(1);
        ll.print();
        ll.addLast(3);
        ll.print();
        ll.addLast(4);
        ll.print();
    }
}