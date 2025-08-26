public class SearchKey {

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

    // Search key
    public int itrSearch(int key) {
        Node temp = head;
        int i = 0;

        while(temp != null) {
            if(temp.data == key) {          // key found
                return i;
            }
            temp = temp.next;
            i++;
        }

        return -1;                          // key not found
    }

    public static void main(String args[]) {
        SearchKey ll = new SearchKey();
        ll.addLL(4);
        ll.addLL(3);
        ll.addLL(2);
        ll.addLL(1);
        ll.print();

        System.out.println(ll.itrSearch(3));
        System.out.println(ll.itrSearch(10));
    }
}