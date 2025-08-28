// Check if LL is Palindrome

public class Palindrome {

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

    // Slow-Fast Approach
    public Node findMid(Node head) {
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;       // +1
            fast = fast.next.next;  //+2
        }
        return slow;                // slow is midNode
    }

    public boolean isPalindrome() {
        if(head == null || head.next == null) {
            return true;
        }
        // step 1 - find mid
        Node midNode = findMid(head);

        // step 2 - reverse 2nd half
        Node prev = null;
        Node curr = midNode;
        Node next;
        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        Node right = prev;      // right half head
        Node left = head;       // left half head

        // step 3 - check left half and right half
        while(right != null ) {
            if(left.data != right.data) {
                return false;
            }

            // if true update
            left = left.next;
            right = right.next;
        }

        return true;
    }

    public static void main(String args[]) {
        Palindrome ll = new Palindrome();
        ll.addLL(1);
        ll.addLL(2);
        ll.addLL(2);
        ll.addLL(1);

        ll.print();
    System.out.println(ll.isPalindrome());
    }
}

// Time Complexity = O(n)
// Space Complexity = O(1)