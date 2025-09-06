// Remove Nth node 

public class Delete_NthPos {

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

    public void deleteNthPos(int position) {
        Node temp = head;
        Node prev = null;

// LL is empty
        if(temp == null) {
            return;
         }
// Head to be deleted
        if(position == 1) {
            head = temp.next;
            return;
        }

// Traverse till given position
        for(int i = 1 ; temp != null && i < position ; i++) {
            prev = temp;
            temp = temp.next;
        }

// If position found, delete
    if(temp != null) {
        prev.next = temp.next;
    } else {
        System.out.println("Data not found!");
    }
        return;
    }

    public static void main(String args[]) {
        Delete_NthPos ll = new Delete_NthPos();
        ll.addLL(5);
        ll.addLL(4);
        ll.addLL(3);
        ll.addLL(2);
        ll.addLL(1);
        ll.print();

        ll.deleteNthPos(3);
        ll.print();
    }
}

// Time Complexity = O(n)