public class Reverse_LL {

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

    public void reverse() {
        Node prev = null;
        Node curr = tail = head;        // update tail as head
        Node next;

        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }


    public static void main(String args[]) {
        Reverse_LL ll = new Reverse_LL();
        ll.addLL(5);
        ll.addLL(4);
        ll.addLL(3);
        ll.addLL(2);
        ll.addLL(1);
        ll.print();

        ll.reverse();
        ll.print();
    }
}

// Time Complexity = O(n)