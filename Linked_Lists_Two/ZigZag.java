public class ZigZag {

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


    public void zigZag() {
        // Find mid
        Node slow = head;
        Node fast = head.next;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        Node mid = slow;

        // Reverse 2nd half
        Node curr = mid.next;       // 2nd half starts 
        mid.next = null;            // 1st half last node -> null
        Node prev = null;
        Node next;

        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        Node left = head;
        Node right = prev;          // i.e node before null
        Node nextL, nextR;

        // alternate merge -> zig-zag merge
        while(left != null && right != null) {
            nextL = left.next;          // initialize nextL
            left.next = right;          
            nextR = right.next;         // initialize nextR
            right.next = nextL;

            left = nextL;               // update
            right = nextR;
        }
    }

    public static void main(String args[]) {
        ZigZag ll = new ZigZag();
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(5);
       // 1 -> 2 -> 3 -> 4 -> 5
       ll.print();
       ll.zigZag();
       ll.print();
       // 1 -> 5 -> 2 -> 4 -> 3 -> null
    }
}
