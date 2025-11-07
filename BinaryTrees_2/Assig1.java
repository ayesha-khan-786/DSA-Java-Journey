//Question 1 :Check if a Binary Tree is univalued or not
import java.util.*;

public class Assig1 {

     static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static boolean uniValued(Node root) {
        if(root == null) {
            return true;
        }

        // the value to compare against all other nodes
        int val = root.data;

        return preOrder(root, val);
    }

    private static boolean preOrder(Node root, int val) {
        if(root == null) {
            return true;
        }

        if(root.data != val) {
            return false;
        }

        return preOrder(root.left, val) && preOrder(root.right, val);
    }

    public static void main(String args[]) {
    /*
            2
           / \
          2   2
         / \ 
        5  2 
     */
    Node root = new Node(2);
    root.left = new Node(2);
    root.right = new Node(2);
    root.left.left = new Node(3);
    root.left.right = new Node(2);

    System.out.println("Tree is a UniValued : ");
    if(uniValued(root)) {
        System.out.println("YES");
    } else {
        System.out.println("NO");
    }
}

}