public class RemoveLL {

    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    public static Node head;
    public static Node tail;
    public static int size;

    public void addLL(int data) {
        Node newNode = new Node(data);
         size++;
        if(head == null) {
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    public void print() {
        if(head == null) {
            System.out.println("Linked list is empty!");
            return;
        }
        Node temp = head;
        while(temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // Remove First LL
    public int removeFirst() {
        if(size == 0) {
            System.out.println("Linked List is empty!");
            return Integer.MIN_VALUE;
        }
         else if(size == 1) {
            int val = head.data;        // store head data in val
            head = tail = null;
            size = 0;
            return val;
        }
        int val = head.data;
        head = head.next;
        size--;
        return val;
    }

    // Remove Last in LL
    public int removeLast() {
        if(size == 0) {
            System.out.println("Linked List is empty!");
            return Integer.MIN_VALUE;
        } 
        else if(size == 1) {
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        // prev : i = size - 2
        Node prev = head;
        for(int i=0 ; i<size-2 ; i++) {
            prev = prev.next;
        }

        int val = tail.data;    // prev.next.data
        prev.next = null;
        tail = prev;
        size--;
        return val;
    }

    public static void main(String args[]) {
        RemoveLL ll = new RemoveLL();
        ll.addLL(4);
        ll.addLL(3);
        ll.addLL(2);
        ll.addLL(1);
        ll.print();

        ll.removeFirst();
        ll.print();

        ll.removeLast();
        ll.print();
        System.out.println(ll.size);
    }
}