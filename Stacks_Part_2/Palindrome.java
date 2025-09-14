import java.util.*;

public class Palindrome {

    public static class Node {
        char data;
        Node next;

        public Node(char data) {
            this.data = data;
            this.next = null;
        }
    }
    public static Node head;
    public static Node tail;

    public static boolean isPalindrome(Node head) {
        Stack<Character> s = new Stack<>();
        Node curr = head;

        // Push all ele in stack
        while(curr != null) {
            s.push(curr.data);
            curr = curr.next;
        }
        // compare with pop ele
        curr = head;
        while(curr != null) {
           
                if(curr.data != s.pop()) {
                    return false;
                }
                curr = curr.next;
            }
            return true;
        
    }
      

    public static void main(String args[]) {
            Node one = new Node('m');
            Node two = new Node('a');
            Node three = new Node('d');
            Node four = new Node('a');
            Node five = new Node('m');
            one.next = two;
            two.next = three;
            three.next = four;
            four.next = five;
        
            boolean condition = isPalindrome(one);
            System.out.println("palindrome: " + condition);

}
    }

    // Time Complexity = o(n) | Space Complexity = O(n)