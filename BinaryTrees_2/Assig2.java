// Question 2 :Invert Binary - Tree Mirror

import java.util.*;

public class Assig2 {

     static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

   public static void invertTree(Node root) {
    if(root == null) {
        return;     // no swap
    }

    // Postorder
    // 1. children - recursively invert left n right tree
    invertTree(root.left);
    invertTree(root.right);

    //2. root - swap left and right children
    Node leftOfRoot = root.left;        // leftOfRoot -> temp
    root.left = root.right;
    root.right = leftOfRoot;
    
   }

    private static void printInOrder(Node root) {
        if(root == null) {
            return;
        }

        printInOrder(root.left);
        System.out.print(root.data + " ");
        printInOrder(root.right);
    }

    public static void main(String args[]) {
    /*
            1
           / \
          2   3
         / \ / \
        4  5 6  7
     */
    Node root = new Node(1);
    root.left = new Node(2);
    root.right = new Node(3);
    root.left.left = new Node(4);
    root.left.right = new Node(5);
    root.right.left = new Node(6);
    root.right.right = new Node(7);

    System.out.println("Original tree : ");
    printInOrder(root);
    System.out.println("\n");
    
   invertTree(root);

   System.out.println("Inverted tree : ");
   printInOrder(root);
   System.out.println("\n");
}

}