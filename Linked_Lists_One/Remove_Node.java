// Remove Nth node from end

public class Remove_Node {

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

    public void deleteNthFromEnd(int n) {
        // calculate size
        int sz = 0;
        Node temp = head;
        while(temp != null) {
            temp = temp.next;
            sz++;
        }

        if(n == sz) {               // if head == n
            head = head.next;       // delete head
            return;
        }

        // sz - n
        int i = 1;
        int idxToFind = sz - n;
        Node prev = head;
        while(i < idxToFind) {
            prev = prev.next;
            i++;
        }

        // reached before node to be deleted
        prev.next = prev.next.next;
        return;
    }

    public static void main(String args[]) {
        Remove_Node ll = new Remove_Node();
        ll.addLL(5);
        ll.addLL(4);
        ll.addLL(3);
        ll.addLL(2);
        ll.addLL(1);
        ll.print();

        ll.deleteNthFromEnd(3);
        ll.print();
    }
}

// Time Complexity = O(n)