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
    public static int size;

     public void addFirst(int data) {
        Node newNode = new Node(data);
        size++;
        if(head == null) {
            head = tail = newNode;
            return;
        }
        newNode.next = head;        
        head = newNode;
    }


    // Methods to add last
    public void addLast(int data) {
        Node newNode = new Node(data);
        size++;
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

    // Add int he Middle of LL
    public void addMiddle(int idx, int data) {
        if(idx == 0) {
            addFirst(data);
            return;
        }
        Node newNode = new Node(data);
        size++;
        Node temp = head;
        int i = 0;      

        while(i < idx-1) {
            temp = temp.next;
            i++;
        }

        // i = idx-1 ; temp -> prev
        newNode.next = temp.next;
        temp.next = newNode;
    }

    public static void main(String args[]) {
        LinkedList ll = new LinkedList();
        ll.addFirst(2);
        ll.addFirst(1);
        ll.addLast(4);
        ll.addLast(5);
        ll.addMiddle(2, 3);
         
         ll.print();
         System.out.println(ll.size);
    }
}